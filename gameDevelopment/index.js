import "./style.css"
import playerImage from "./assets/shadow_dog.png"
const canvas = document.getElementById("game-canvas");
const ctx = canvas.getContext("2d")
const CANVAS_WIDTH = canvas.width = 600;
const CANVAS_HEIGHT = canvas.height = 600;
const player_image = new Image()
player_image.src = playerImage
function animate(){
    ctx.clearRect(0,0,CANVAS_WIDTH, CANVAS_HEIGHT);
    ctx.drawImage(player_image, 0, 0)
    
    requestAnimationFrame(animate)
}
animate()