package solid_principle

class  BeforeDependencyInversion(){
    class Car(private val engine: Engine) {
        fun start() {
            engine.start()
        }
    }

    class Engine {
        fun start() {}
    }

    class DieselEngine {
        fun start() {}
    }

}

class DependencyInversion {
    interface EngineInterface {
        fun start()
    }

    class Car(private val engine: EngineInterface) {
        fun start() {
            engine.start()
        }
    }

    class PetrolEngine : EngineInterface {
        override fun start() {}
    }

    class HybridEngine: EngineInterface {
        override fun start() {}
    }

    class DieselEngine : EngineInterface {
        override fun start() {}
    }
}