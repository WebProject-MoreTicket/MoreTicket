document.addEventListener("DOMContentLoaded", function () {
    const sliderWrap = document.querySelector(".slider__wrap");
    const sliderImg = document.querySelector(".slider__img");
    const sliderInner = document.querySelector(".slider__inner");
    const sliders = document.querySelectorAll(".slider");
    const sliderBtnPrev = document.querySelector(".prev");
    const sliderBtnNext = document.querySelector(".next");
    const sliderDot = document.querySelector(".slider__dot");

    let currentIndex = 0;
    const sliderCount = sliders.length;
    const sliderWidth = sliderImg.offsetWidth;

    // 슬라이더 초기 위치를 중앙으로 설정
    function setInitialPosition() {
        sliderInner.style.transform = `translateX(${-sliderWidth * currentIndex}px)`;
    }

    // 닷 메뉴 생성
    function createDots() {
        sliders.forEach((_, index) => {
            const dot = document.createElement("a");
            dot.href = "#";
            dot.className = "dot";
            if (index === 0) dot.classList.add("active");
            sliderDot.appendChild(dot);
        });
    }

    createDots();
    setInitialPosition(); // 초기 위치 설정

    // 슬라이더 이동
    function gotoSlider(index) {
        sliderInner.style.transform = `translateX(${-sliderWidth * index}px)`;
        currentIndex = index;

        // 닷 메뉴 활성화
        const dots = document.querySelectorAll(".slider__dot .dot");
        dots.forEach(dot => dot.classList.remove("active"));
        dots[currentIndex].classList.add("active");
    }

    sliderBtnPrev.addEventListener("click", () => {
        const prevIndex = (currentIndex - 1 + sliderCount) % sliderCount;
        gotoSlider(prevIndex);
    });

    sliderBtnNext.addEventListener("click", () => {
        const nextIndex = (currentIndex + 1) % sliderCount;
        gotoSlider(nextIndex);
    });

    document.querySelectorAll(".slider__dot .dot").forEach((dot, index) => {
        dot.addEventListener("click", (e) => {
            e.preventDefault();
            gotoSlider(index);
        });
    });
});
