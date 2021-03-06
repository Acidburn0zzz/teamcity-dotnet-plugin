<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>
<jsp:useBean id="params" class="jetbrains.buildServer.dotnet.DotnetParametersProvider"/>
<jsp:useBean id="teamcityPluginResourcesPath" scope="request" type="java.lang.String"/>

<script type="text/javascript">
    BS.DotnetParametersForm.appendProjectFile.push("restore");
    BS.DotnetParametersForm.paths["restore"] = "Projects";
</script>

<tr class="advancedSetting">
    <th><label for="${params.restoreSourceKey}">NuGet package sources:</label></th>
    <td>
        <props:textProperty name="${params.restoreSourceKey}" className="longField" expandable="true"/>
        <span class="error" id="error_${params.restoreSourceKey}"></span>
        <span class="smallNote">Specifies a NuGet package sources to use during the restore.</span>
    </td>
</tr>

<tr class="advancedSetting">
    <th><label for="${params.restorePackagesKey}">Packages path:</label></th>
    <td>
        <props:textProperty name="${params.restorePackagesKey}" className="longField"/>
        <bs:vcsTree fieldId="${params.restorePackagesKey}" dirsOnly="true"/>
        <span class="error" id="error_${params.restorePackagesKey}"></span>
        <span class="smallNote">Directory to install packages in.</span>
    </td>
</tr>

<tr class="advancedSetting">
    <th class="noBorder"></th>
    <td class="noBorder">
        <props:checkboxProperty name="${params.restoreParallelKey}"/>
        <label for="${params.restoreParallelKey}">Disables restoring multiple project packages in parallel</label><br/>
        <props:checkboxProperty name="${params.restoreRootProjectKey}"/>
        <label for="${params.restoreRootProjectKey}">Restore only root project packages</label><br/>
        <props:checkboxProperty name="${params.restoreNoCacheKey}"/>
        <label for="${params.restoreNoCacheKey}">Do not cache packages and http requests</label><br/>
        <props:checkboxProperty name="${params.restoreIgnoreFailedKey}"/>
        <label for="${params.restoreIgnoreFailedKey}">Treat package source failures as warnings</label>
    </td>
</tr>

<tr class="advancedSetting">
    <th><label for="${params.restoreConfigKey}">Configuration file:</label></th>
    <td>
        <props:textProperty name="${params.restoreConfigKey}" className="longField"/>
        <bs:vcsTree fieldId="${params.restoreConfigKey}"/>
        <span class="error" id="error_${params.restoreConfigKey}"></span>
        <span class="smallNote">The NuGet configuration file to use.</span>
    </td>
</tr>

<tr class="advancedSetting">
    <th><label for="${params.verbosityKey}">Logging verbosity:</label></th>
    <td>
        <props:selectProperty name="${params.verbosityKey}" enableFilter="true" className="mediumField">
            <props:option value="">&lt;Default&gt;</props:option>
            <c:forEach var="item" items="${params.verbosity}">
                <props:option value="${item}"><c:out value="${item}"/></props:option>
            </c:forEach>
        </props:selectProperty>
        <span class="error" id="error_${params.verbosityKey}"></span>
    </td>
</tr>