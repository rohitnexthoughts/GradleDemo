package com.crowdlending.eligibility

import com.crowdlending.enums.CommonPropertyType
import com.crowdlending.enums.Enums
import com.crowdlending.loan.LoanPurpose
import com.crowdlending.tenant.CommonProperty
import com.crowdlending.tenant.Tenant

class EligibilityModel {

    static auditable = [ignoreEvents: ["onSave"], ignore: ['version', 'lastUpdated', 'dateCreated', 'uuid']]

    CommonPropertyType factor
    Double minValue = 0.00
    Double maxValue = 0.00
    BigDecimal score

    Enums.RiskModelType modelType = Enums.RiskModelType.RANGE

    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated

    LoanPurpose loanPurpose
    Date minimumDate
    Date maximumDate
    Boolean isEnable

    static belongsTo = [tenant: Tenant]

    static hasMany = [elements: CommonProperty]

    static constraints = {
        minValue(nullable: true)
        maxValue(nullable: true)
        elements(nullable: true)
        loanPurpose(nullable: true)
        minimumDate(nullable: true)
        maximumDate(nullable: true)
        isEnable(nullable: true)
    }

}
