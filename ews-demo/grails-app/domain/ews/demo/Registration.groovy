package ews.demo

class Registration {
    String name
    Date dateOfBirth
    String gender
    String address
    String city
    String state
    String zipcode
    String email
    Date dateCreated // Note: Grails will automatically fill in the value when it gets saved to the database.
    /** note:
    Date lastUpdated // Note: grails will fill in the date each subsequent time the record is saved back to DB

    static mapping = { autoTimestamp false} // to disable it, you can define a static mapping
    static mapping = { sort "startDate"}  // return sorted Races list, refer grails.org/GORM+-+Mapping+DSL
        if you want grails to do something more sophisticated than simply fill in a timestamp field, you can create
        some intuitively named closures:
    def beforeInsert = {}
    def beforeDelete = {}
    def onLoad = {}
    **/
    static constraints = {
    }
}
