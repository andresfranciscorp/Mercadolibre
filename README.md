Prueba meli
=====================

This is an test to MercadoLibre how to implement observable queries

Introduction
-------------

### Functionality
The test app shows the list of a search and the list of categories stored in the database.

### Implementation

#### Data layer

The database is created using Room and has one entity: a `CAtegory`. Room generates the corresponding SQLite table at
runtime.

Queries are executed in the `CategoryDao` class. The user retrieval is done via an observable query implemented using a
`Flowable`. Every time the user data is updated, the Flowable object will emit automatically, allowing to update the UI
based on the latest data. The Flowable will emit only when the query result contains at least a row. When there is no
data to match the query, the Flowable will not emit.

#### Presentation layer

The app has a main Activity that displays the categories list.
The Activity works with a ViewModel to do the following:
* subscribe to the emissions of the  update the UI every time there is a new category  emitted
* notify the ViewModel when retrieve the category list.
The ViewModel works with the data source to get and save the data.

Room guarantees that the observable query will be triggered on a background thread. In the Activity, the Flowable events
are set to be received on the main thread, so the UI can be updated. The insert query is synchronous so it's wrapped in
a Completable and executed on a background thread. On completion, the Activity is notified on the main thread.

Secondly has a search Activity where the search result is displayed
