import controller.MainController
import javafx.stage.Stage
import tornadofx.*
import views.ChooseMode


class MyApp: App(ChooseMode::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 600.0
        stage.height = 300.0
    }
    private val controller: MainController by inject()

    override fun stop() {
        controller.stopGame()
        controller.serverShutdown()
        super.stop()
    }
}


fun main(args: Array<String>) {
    launch<MyApp>(args)
}
