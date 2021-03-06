/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * See LICENSE in the project root for license information.
 */

package jetbrains.buildServer.dotnet.commands.dotnet

import jetbrains.buildServer.dotnet.DotnetConstants
import jetbrains.buildServer.dotnet.commands.CommandType
import jetbrains.buildServer.serverSide.InvalidProperty

/**
 * Provides parameters for dotnet nuget delete command.
 */
class NugetDeleteCommandType : CommandType() {
    override val name: String
        get() = DotnetConstants.COMMAND_NUGET_DELETE

    override val editPage: String
        get() = "editNugetDeleteParameters.jsp"

    override val viewPage: String
        get() = "viewNugetDeleteParameters.jsp"

    override fun validateProperties(properties: Map<String, String>): Collection<InvalidProperty> {
        val invalidProperties = arrayListOf<InvalidProperty>()

        if (properties[DotnetConstants.PARAM_NUGET_DELETE_ID].isNullOrBlank()) {
            invalidProperties.add(InvalidProperty(DotnetConstants.PARAM_NUGET_DELETE_ID, DotnetConstants.VALIDATION_EMPTY))
        }

        if (properties[DotnetConstants.PARAM_NUGET_DELETE_SOURCE].isNullOrBlank()) {
            invalidProperties.add(InvalidProperty(DotnetConstants.PARAM_NUGET_DELETE_SOURCE, DotnetConstants.VALIDATION_EMPTY))
        }

        if (properties[DotnetConstants.PARAM_NUGET_DELETE_API_KEY].isNullOrBlank()) {
            invalidProperties.add(InvalidProperty(DotnetConstants.PARAM_NUGET_DELETE_API_KEY, DotnetConstants.VALIDATION_EMPTY))
        }

        return invalidProperties
    }
}
