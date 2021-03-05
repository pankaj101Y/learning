<#compress>
    {
    "body":{
    "SiebelMessage":{
    "IntObjectName": "CartIo",
    "ListOfCartIo":{
    "Cart":{
    <#if ccId??>
        "CartId": "<#if ccId??>${ccId?replace(",","")}</#if>",
        "ListOfCartQuote": {
        "CartQuote":[
        <#if cartItems??><#list cartItems as cartItem>
            {
            "TotalPrice":"<#if cartItem.totalPrice??>${cartItem.totalPrice?replace(",","")}</#if>",
            "TotalDiscount": "<#if cartItem.totalDiscount??>${cartItem.totalDiscount?replace(",","")}</#if>",
            "Taxation": "<#if cartItem.taxation??>${cartItem.taxation?replace(",","")}</#if>",
            "Source": "eCAF",
            "Channel":"<#if cartItem.channel??>${cartItem.channel}</#if>",
            "ProductType": "<#if cartItem.productType??><#if cartItem.productType?upper_case == 'DTH'>${cartItem.productType?upper_case}<#else>${cartItem.productType?capitalize}</#if></#if>",
            "CorrelationId": "<#if cartItem.id??>${cartItem.id?replace(",","")}</#if>",
            "QuoteId": "<#if cartItem.ccCartItemId??>${cartItem.ccCartItemId?replace(",","")}</#if>",
            "ListOfCartQuoteItem":{
            "CartQuoteItem":[
            <#if cartItem.cartSubItems??>
                <#assign isFirstElement=false>
                <#list cartItem.cartSubItems as subItem>
                    <#if subItem.parentSubItem??>
                    <#else>
                        <#if isFirstElement==true>,</#if><@setCartItems subItem></@><#assign isFirstElement=true>
                    </#if>
                </#list></#if>
            ]
            }
            }<#sep>,</#sep>
        </#list></#if>
        ]
        }
    </#if>
    }
    }
    }
    }
    }
</#compress>


<#macro setCartItems subItem>
    {
    <#assign check=false>
    <#if subItem.descriptionClob??><#assign jsonDesc= subItem.descriptionClob></#if>
    "QuoteItemId": "<#if subItem.ccSubItemId??>${subItem.ccSubItemId?replace(",","")}</#if>",
    "Circle": "<#if circleId??>${circleId}</#if>",
    "Price": "<#if subItem.price??>${subItem.price?replace(",","")}</#if>",
    "Discount":"<#if subItem.discount??>${subItem.discount?replace(",","")}</#if>",
    "TotalDiscount":"<#if subItem.totalDiscount??>${subItem.totalDiscount?replace(",","")}</#if>",
    "ConnectionType": "<#if subItem.connectionType??>${subItem.connectionType?capitalize}</#if>",
    "PartNumber": "<#if subItem.planId??>${subItem.planId}</#if>",
    "OrderSubType": "<#if subItem.subLobType?has_content>${subItem.subLobType}<#else>New Registration</#if>",
    "OrderType": "<#if subItem.subLob??>${subItem.subLob}</#if>",
    "Source": "eCAF",
    "Channel":"<#if subItem.channel??>${subItem.channel}</#if>",
    "ProductName": "<#if subItem.productName??>${subItem.productName?upper_case}</#if>",
    "ProductType": "<#if subItem.productName??><#if subItem.productName?upper_case == 'DTH'>${subItem.productName?upper_case}<#else>${subItem.productName?capitalize}</#if></#if>",
    "CustomerType": "B2C",
    "CustomerClass": "<#if subItem.subLob??><#if subItem.subLob=="COIP" || subItem.subLob=="COIP_ADDON">Corporate<#elseif subItem.descriptionClob?? && subItem.descriptionClob.isAdvanceRentailPlan?? && subItem.descriptionClob.isAdvanceRentailPlan==true>Advance Retail<#else>Retail</#if><#else>Retail</#if>",
    "CorrelationId": "<#if subItem.id??>${subItem.id?replace(",","")}</#if>",
    "Stage": "",
    "Reason": "<#if subItem.reason??>${subItem.reason}</#if>",
    "Status": "<#if subItem.status??>${subItem.status}</#if>",
    "SubStatus": "",
    "ExistingCustomerName": "",
    "ExistingNumber" : "",
    "Description" : "",
    "LeadNumber":"<#if subItem.leadId??>${subItem.leadId}</#if>",
    "ReferenceLeadNum":"<#if subItem.referenceLeadId??>${subItem.referenceLeadId}</#if>",
    "MobileNumber": "<#if subItem.descriptionClob?? && subItem.descriptionClob.existingMobileNo??>${subItem.descriptionClob.existingMobileNo}<#elseif subItem.cartSubItemAttributes?? && subItem.cartSubItemAttributes.validatedMsisdn??>${subItem.cartSubItemAttributes.validatedMsisdn}</#if>",
    "ParentAccountNumber": "<#if subItem.descriptionClob?? && subItem.descriptionClob.coipAccountNo??>${subItem.descriptionClob.coipAccountNo}</#if>",
    "SIId": "<#if subItem.cartSubItemAttributes?? && subItem.cartSubItemAttributes.rtn?? && subItem.cartSubItemAttributes.rtn?has_content>${subItem.cartSubItemAttributes.rtn}</#if>",
    "ChannelOrderId": "<#if subItem.channelOrderId??>${subItem.channelOrderId}</#if>",
    "ListOfCartQuoteItemXA": {<#if subItem.ccCartSubItemAttributes??>
    "CartQuoteItemXA":[
    <#list subItem.ccCartSubItemAttributes as xaKey, xaValue>
        {
        "Key":"<#if xaKey??>${xaKey}</#if>",
        "Value":"<#if xaValue??>${xaValue?js_string}</#if>",
        "DataType":"Text"
        }
        <#sep>,</#sep>
    </#list>]
</#if>},
    "CartQuoteItem": [
    <#assign isTopupBoosterMultilineEnabled = false>
    <#if subItem.childSubItems??>
        <#list subItem.childSubItems as chilSubItem>
            <#if chilSubItem.subLob?? && ("TOPUP"==chilSubItem.subLob || "BOOSTER"==chilSubItem.subLob || "PROPOSITION"==chilSubItem.subLob)><#assign isTopupBoosterMultilineEnabled = true ></#if>
        </#list>
    </#if>
    <#if !isTopupBoosterMultilineEnabled && jsonDesc?? && jsonDesc.boosters??><#assign boosters=jsonDesc.boosters>
        <#if boosters??><#assign check=true>
            <#list boosters as booster>
                <@setBooster booster></@setBooster>
                <#sep>,</#sep>
            </#list>
        </#if>
    </#if>
    <#if !isTopupBoosterMultilineEnabled && jsonDesc??&& jsonDesc.topUpDetails??><#assign topUpList=jsonDesc.topUpDetails>
        <#if topUpList??>
            <#assign flag=false>
            <#list topUpList as topUp>
                <#if topUp.isSelected?? && topUp.isSelected==true>
                    <#assign check=true>
                    <#if flag==true>,</#if><#assign flag=true>
                    <@setTopUp topUp></@setTopUp>
                </#if>
            </#list>
        </#if>
    </#if>

    <#if !isTopupBoosterMultilineEnabled && jsonDesc??&& jsonDesc.meshes??><#assign meshes=jsonDesc.meshes>
        <#if meshes??>
            <#assign flag=false>
            <#list meshes as mesh>
                <#if check==true>,</#if><#assign check=true>
                <@setMesh mesh></@setMesh>
            </#list>
        </#if>
    </#if>

    <#if subItem.childSubItems??>
        <#if subItem.childSubItems?size!=0><#assign childComma = false></#if>
        <#list subItem.childSubItems as chilSubItem>
            <#if !(chilSubItem.subLob?? && "TOPUP"==chilSubItem.subLob && chilSubItem.descriptionClob?? && (!chilSubItem.descriptionClob.isSelected?? || chilSubItem.descriptionClob.isSelected == false))>
                <#if childComma == true || check==true>,</#if><#assign childComma = true>
                <@setCartItems chilSubItem></@>
            </#if>
        </#list>
    </#if>
    ]

    }
</#macro>



<#macro setBooster booster>
    {
    "Circle": "<#if circleId??>${circleId}</#if>",
    "Price": "<#if booster.pricePoint??>${booster.pricePoint}</#if>",
    "ConnectionType": "",
    "PartNumber": "<#if booster.itemCode??>${booster.itemCode}</#if>",
    "OrderSubType": "New Registration",
    "OrderType": "BOOSTER",
    "Source": "eCAF",
    "ProductName": "",
    "ProductType": "Postpaid",
    "CustomerType": "B2C",
    "CustomerClass": "Retail",
    "CorrelationId": "",
    "Stage": "",
    "Reason": "",
    "Status": "",
    "SubStatus": "",
    "ExistingCustomerName": "",
    "ExistingNumber" : "",
    "Description" : "",
    "ListOfCartQuoteItemXA": {
    },
    "CartQuoteItem": [
    ]
    }
</#macro>


<#macro setTopUp topUp>
    {
    "Circle": "<#if circleId??>${circleId}</#if>",
    "Price": "<#if topUp.amount??>${topUp.amount}</#if>",
    "ConnectionType": "",
    "PartNumber": "<#if topUp.schemeId??>${topUp.schemeId}</#if>",
    "OrderSubType": "New Registration",
    "OrderType": "TOPUP",
    "Source": "eCAF",
    "ProductName": "",
    "ProductType": "Telemedia",
    "CustomerType": "B2C",
    "CustomerClass": "Retail",
    "CorrelationId": "",
    "Stage": "",
    "Reason": "",
    "Status": "",
    "SubStatus": "",
    "ExistingCustomerName": "",
    "ExistingNumber" : "",
    "Description" : "",
    "ListOfCartQuoteItemXA": {
    },
    "CartQuoteItem": [
    ]
    }
</#macro>

<#macro setMesh mesh>
    {
    "Circle": "<#if circleId??>${circleId}</#if>",
    "Price": "<#if mesh.price??>${mesh.price}</#if>",
    "ConnectionType": "",
    "PartNumber": "<#if mesh.productSerialNumber??>${mesh.productSerialNumber}</#if>",
    "OrderSubType": "New Registration",
    "OrderType": "MESH",
    "Source": "eCAF",
    "ProductName": "",
    "ProductType": "Telemedia",
    "CustomerType": "B2C",
    "CustomerClass": "Retail",
    "CorrelationId": "",
    "Stage": "",
    "Reason": "",
    "Status": "",
    "SubStatus": "",
    "ExistingCustomerName": "",
    "ExistingNumber" : "",
    "Description" : "",
    "ListOfCartQuoteItemXA": {
    },
    "CartQuoteItem": <#if mesh.children??><@setMeshes mesh.children/><#else>[]</#if>
    }
</#macro>

<#macro setMeshes meshes>
    <#if meshes??>
        [
        <#list meshes as mesh>
            <#if mesh??></#if>
            <@setMesh mesh/><#sep>,</#sep>
        </#list>
        ]
    </#if>
</#macro>
