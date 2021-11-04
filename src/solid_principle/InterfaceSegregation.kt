package solid_principle

class BeforeInterfaceSegregation {
    interface VehicleInterface {
        fun drive()
        fun stop()
        fun refuel()
        fun openDoors()
    }


    class Motorcycle : VehicleInterface {
        // Can be implemented
        override fun drive() {}
        override fun stop() {}
        override fun refuel() {}


        //Pain point
        // Can not be implemented
        override fun openDoors() {}
    }
}

class InterfaceSegregation {

    interface VehicleInterface {
        fun drive()
        fun stop()
        fun refuel()
    }

    interface DoorInterface {
        fun openDoors()
    }

    class Car : VehicleInterface, DoorInterface {
        override fun drive() {}
        override fun stop() {}
        override fun refuel() {}
        override fun openDoors() {}
    }

    class Motorcycle : VehicleInterface {
        override fun drive() {}
        override fun stop() {}
        override fun refuel() {}
    }
}