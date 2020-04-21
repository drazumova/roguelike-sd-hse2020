package views

import controller.MainController
import data.*
import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections.observableArrayList
import javafx.scene.input.KeyEvent
import javafx.scene.layout.Background
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.text.TextFlow
import tornadofx.*
import java.awt.Font


class LevelView : View() {

    private val wSize: Int = 50
    private val hSize: Int = 50
    private val controller: MainController by inject()
    private lateinit var gameRoot: GridPane


    private val render = LevelRender()
//    private val fieldModel = GameFieldModel()
    private val fieldProperty = SimpleStringProperty(this, "field", render.drawContext(wSize, hSize, mapOf()))
    private var field by fieldProperty


    override val root = vbox {
        style {
            backgroundColor += Color.BLACK
        }
        keyboard {
            addEventHandler(KeyEvent.KEY_PRESSED) {
                controller.addToActionQueue(it.code.name)
//                println(it.code)
            }
        }
        label {
            bind(fieldProperty)
            style {
                textFill = Color.WHITE
                padding = box(10.px)
                font = javafx.scene.text.Font.font(Font.MONOSPACED)
            }
        }
    }

    init {
        controller.runGame()
        update(controller.getContext()?.getMap()!!)
    }

    fun update(ctx: Map<Point, List<GameObject>>) {
        field = render.drawContext(wSize, hSize, ctx)
    }

}

//class GameFieldModel(field: String) : ItemViewModel<String>(field) {
//    val field = bind(String)
//}