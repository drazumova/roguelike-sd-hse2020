package controller

import data.Context
import event.PlayerEvent
import logic.GameManager
import tornadofx.Controller
import views.LevelView
import java.io.File
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.random.Random

class MainController : Controller() {
    var usePath: File? = null
    private val channel = ConcurrentLinkedQueue<String>()
    private val gameManager = GameManager()

    fun addToActionQueue(button: String) {
        channel.add(button)
    }

    fun getContext(): Context? {
        TODO()
    }

    fun saveContext(saveDir: File) {
        TODO()
    }

    fun runGame() {
        runAsync {
            val lvl = gameManager.createLevel(Random.nextInt())
            lvl.addReaction {
                //TODO call level update
                find<LevelView>().drawContext(lvl.getMap())
            }
            val loop = gameManager.runLevel(lvl, listOf(PlayerEvent(channel)))
        }
    }
}

//class ContextModel(ctx: Context) : ItemViewModel<Context>(ctx) {
//    val name = bind(Person::nameProperty)
//    val title = bind(Person::titleProperty)
//}
//
//class ContextProp(ctx: ObservableMap<Point, GameObject>?) {
//    val prop = SimpleMapProperty<Point, GameObject>(this, "ctx", ctx)
//
//}