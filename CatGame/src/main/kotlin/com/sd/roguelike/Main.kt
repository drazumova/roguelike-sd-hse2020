package com.sd.roguelike

import com.sd.roguelike.controller.MainController
import com.sd.roguelike.views.MenuView
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch


class MyApp : App(MenuView::class) {
    override fun start(stage: Stage) {
        super.start(stage)
//        stage.width = 500.0
//        stage.height = 500.0
    }

    private val controller: MainController by inject()

    override fun stop() {
        controller.stopGame()
        super.stop()
    }
}


fun main(args: Array<String>) {
    launch<MyApp>(args)
}