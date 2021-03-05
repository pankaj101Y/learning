{
"salutation": "<#if !isCommonKyc><#if kyc.title??>${kyc.title}</#if><#elseIf kyc.title??>${kyc.title?removeEnding(".")}</#if>"
"title":${kyc.title}
}