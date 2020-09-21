package com.github.lazyf1sh.sandbox.wicket.examples.pages.chartupdater;

import org.apache.wicket.Application;
import org.apache.wicket.protocol.ws.WebSocketSettings;
import org.apache.wicket.protocol.ws.api.IWebSocketConnection;
import org.apache.wicket.protocol.ws.api.message.ConnectedMessage;
import org.apache.wicket.protocol.ws.api.message.IWebSocketPushMessage;
import org.apache.wicket.protocol.ws.api.registry.IKey;
import org.apache.wicket.protocol.ws.api.registry.IWebSocketConnectionRegistry;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author Ivan Kopylov
 */
public class ChartUpdater
{
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    public static void start(ConnectedMessage message)
    {
        Record[] data = generateData();

        // create an asynchronous task that will write the data to the client
        UpdateTask updateTask = new UpdateTask(message.getApplication(), message.getSessionId(), message.getKey(), data);
        scheduledExecutorService.schedule(updateTask, 1, TimeUnit.SECONDS);
    }


    /**
     * Generates some random data to send to the client
     *
     * @return records with random data
     */
    private static Record[] generateData()
    {
        Random randomGenerator = new Random();
        Record[] data = new Record[1000];
        for (int i = 0; i < 1000; i++)
        {
            Record r = new Record();
            r.year = 2000 + i;
            r.field = (i % 2 == 0) ? "Company 1" : "Company 2";
            r.value = randomGenerator.nextInt(1500);
            data[i] = r;
        }
        return data;
    }


    /**
     * A task that sends data to the client by pushing it to the web socket connection
     */
    private static class UpdateTask implements Runnable
    {
        private static final String JSON_SKELETON = "{ \"year\": \"%s\", \"field\": \"%s\", \"value\": %s }";

        /**
         * The following fields are needed to be able to lookup the IWebSocketConnection from
         * IWebSocketConnectionRegistry
         */
        private final String applicationName;
        private final String sessionId;
        private final IKey   key;

        /**
         * The data that has to be sent to the client
         */
        private final Record[] data;

        private UpdateTask(Application application, String sessionId, IKey key, Record[] data)
        {
            this.applicationName = application.getName();
            this.sessionId = sessionId;
            this.key = key;
            this.data = data;
        }

        @Override
        public void run()
        {
            Application application = Application.get(applicationName);
            WebSocketSettings webSocketSettings = WebSocketSettings.Holder.get(application);
            IWebSocketConnectionRegistry webSocketConnectionRegistry = webSocketSettings.getConnectionRegistry();

            int dataIndex = 0;

            while (dataIndex < data.length)
            {
                IWebSocketConnection connection = webSocketConnectionRegistry.getConnection(application, sessionId, key);
                try
                {
                    Record record = data[dataIndex++];
                    String json = String.format(JSON_SKELETON, record.year, record.field, record.value);

                    if (connection == null || !connection.isOpen())
                    {
                        // stop if the web socket connection is closed
                        return;
                    }
                    connection.sendMessage(json);
                    connection.sendMessage(new IWebSocketPushMessage()
                    {
                    });


                    // sleep for a while to simulate work
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (InterruptedException x)
                {
                    Thread.currentThread().interrupt();
                    break;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    /**
     * The data that is being sent to the client in JSON format
     */
    private static class Record
    {
        private int    year;
        private String field;
        private int    value;
    }
}