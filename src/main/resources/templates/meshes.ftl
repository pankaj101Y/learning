<#--"meshes":"<#if descriptionClob.meshes??><${descriptionClob.meshes?join(", ")}></#if>"-->


"meshes":<#if descriptionClob.meshes??><@setMeshes descriptionClob.meshes/><#else>[]</#if>

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


<#macro setMesh mesh>
{
    "productSerialNumber": "<#if mesh.productSerialNumber??>${mesh.productSerialNumber}</#if>",
    "planCode": "<#if mesh.planCode??>${mesh.planCode}</#if>",
    "createdBy": "<#if mesh.createdBy??>${mesh.createdBy}</#if>",
    "type": "<#if mesh.type??>${mesh.type}</#if>",
    "category": "<#if mesh.category??>${mesh.category}</#if>",
    "podsCount": "<#if mesh.podsCount??>${mesh.podsCount?c}</#if>",
    "area": "<#if mesh.area??>${mesh.area?c}</#if>",
    "price":  "<#if mesh.price??>${mesh.price?c}</#if>",
    "parent": "<#if mesh.isParent??>${mesh.isParent?c}</#if>",
    "children": <#if mesh.children??><@setMeshes mesh.children/><#else>[]</#if>
}
</#macro>
