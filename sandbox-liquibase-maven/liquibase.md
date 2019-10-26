# Liquibase

- MD5 checksum is stored with each changeset entry in the database changelog table to detect differences between what is currently in the changelog and what was actually ran against the database.
- The general idea is that the checksums should be based on what is executed against the database. So any changes to the changes or referenced sql files wouldbe included in the changeset, changes to used changelog parameters, changes to the sqlVisitors. Preconditions, attributes like dbms, contexts 
  onFail, validCheckSum, and rollback are not included.Preconditions, attributes like dbms, contexts, onFail, validCheckSum, and rollback are not included ([link](http://forum.liquibase.org/topic/preconditions-affect-checksum))
- DATABASECHANGELOG table.
- One operation - one changeset, because DDL operations are run in different transactions.
- Do not change past changesets. Write new ones to correct previous ones.
- Change set id and author name: Combination of change set id and author name uniquely identifies a change set. Change set id should be logical and explanatory name and author name should easily identify the developer who created the change set.