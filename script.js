function toggleMenu() {
    //targetting menu-links and hamburger icon
    const menu = document.querySelector(".menu-links");
    const icon = document.querySelector(".hamburger-icon");
    //Add and remove the open class in that element
    menu.classList.toggle("open")
    icon.classList.toggle("open")
}