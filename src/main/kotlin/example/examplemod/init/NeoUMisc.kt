package example.examplemod.init

import example.examplemod.reg.CorrosionReg


object NeoUMisc {
    init {
        CorrosionReg.registerDefault()
        println("Hello from Misc")
    }
}
