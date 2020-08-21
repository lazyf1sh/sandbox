package com.github.lazyf1sh.sandbox.wicket.examples.converter;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.convert.converter.BigDecimalConverter;
import org.apache.wicket.validation.IValidationError;
import org.apache.wicket.validation.ValidationError;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Ivan Kopylov
 */
public class BigDecimalConverterExample extends WebPage
{
    private static final long serialVersionUID = 1388829190396256439L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> form = new Form("myForm");

        TextField<BigDecimal> input = new TextField<BigDecimal>("input", Model.of())
        {
            private static final long serialVersionUID = 8642924278318065944L;

            @Override
            public <C> IConverter<C> getConverter(final Class<C> type)
            {
                BigDecimalConverter bigDecimalConverter = new BigDecimalConverter()
                {
                    private static final long serialVersionUID = 9058826619460123061L;

                    @Override
                    protected NumberFormat newNumberFormat(Locale locale)
                    {
                        //                        Locale locale = new Locale(componentData.getFormData().getLanguage());

                        DecimalFormat result = new DecimalFormat("-#.#;+#.#");
                        result.setGroupingUsed(false);
                        result.setDecimalFormatSymbols(new DecimalFormatSymbols(locale));
                        result.setParseBigDecimal(true);
                        result.setMinimumIntegerDigits(1);
                        result.setDecimalSeparatorAlwaysShown(false);
                        return result;
                    }
                };
                return (IConverter<C>)bigDecimalConverter;
            }

            @Override
            protected ValidationError newValidationError(ConversionException cause)
            {
                ValidationError validationError = new ValidationError();
                return validationError;
            }

            @Override
            public void error(IValidationError error)
            {
                super.error(error);

            }
        };
        input.add(new AjaxFormComponentUpdatingBehavior("keyup")
        {
            @Override
            protected void onUpdate(final AjaxRequestTarget target)
            {
                target.getHeaderResponse();
            }

            @Override
            protected void updateAjaxAttributes(final AjaxRequestAttributes attributes)
            {
                super.updateAjaxAttributes(attributes);
            }
        });

        form.add(input);
        input.setType(BigDecimal.class);
        add(form);
    }
}
