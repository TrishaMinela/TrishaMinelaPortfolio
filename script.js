function toggleMenu() {
    //targetting menu-links and hamburger icon
    const menu = document.querySelector(".menu-links");
    const icon = document.querySelector(".hamburger-icon");
    //Add and remove the open class in that element
    menu.classList.toggle("open")
    icon.classList.toggle("open")
}

function openInNewTab(url) {
    window.open(url, '_blank');
}

function openInSameTab(url) {
    window.location.href = url;
}