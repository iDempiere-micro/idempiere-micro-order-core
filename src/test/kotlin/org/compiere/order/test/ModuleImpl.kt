package org.compiere.order.test

import software.hsharp.modules.DataModule
import software.hsharp.modules.EnvironmentModule
import software.hsharp.modules.Module

class ModuleImpl(
    environment: EnvironmentModule,
    logic: LogicModule,
    data: MainDataModule
) :
    EnvironmentModule by environment,
    LogicModule by logic,
    DataModule by data,
    Module
