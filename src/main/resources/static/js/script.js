

        let menu1 = document.querySelector('.navbar');
        document.querySelector('.menu').onclick = () => {
            menu1.classList.toggle('active');
        }

        // Code By Webdevtrick ( https://webdevtrick.com )
        const items = document.querySelectorAll(".accordion a");

        function toggleAccordion() {
            this.classList.toggle('active');
            this.nextElementSibling.classList.toggle('active');
        }

        items.forEach(item => item.addEventListener('click', toggleAccordion));
    
    
    console.log("antim ")

const toggleSidebar=()=>{

if($(".sidebar").is(":visible"))
{
//true 

$(".sidebar").css("display","none");
$(".content").css("margin-left","0%");
}
else{

$(".sidebar").css("display","block");
$(".content").css("margin-left","20%");
}
}