package example.examplemod.init

import example.examplemod.reg.CorrosionReg


object NeoUMisc {
    init {
        CorrosionReg.registerDefault()
        CorrosionReg.registerCreate()
        println("Hello from Misc")
    }
}
