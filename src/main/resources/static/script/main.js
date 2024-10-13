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

function showEvents(listId) {
    // 모든 이벤트 리스트 숨기기
    var eventLists = document.querySelectorAll('.event-list');
    eventLists.forEach(function (list) {
        list.style.display = 'none';  // 리스트를 숨길 때 'none'으로 처리
    });

    // 선택한 리스트만 보이도록 설정
    var selectedList = document.getElementById(listId);
    selectedList.style.display = 'flex';  // 리스트를 보일 때 'flex'로 처리
}

function showVideos(listId) {
    // 모든 이벤트 리스트 숨기기
    var videoLists = document.querySelectorAll('.video-list');
    videoLists.forEach(function (list) {
        list.style.display = 'none';  // 리스트를 숨길 때 'none'으로 처리
    });

    // 선택한 리스트만 보이도록 설정
    var selectedList = document.getElementById(listId);
    selectedList.style.display = 'flex';  // 리스트를 보일 때 'flex'로 처리
}

function selectItem(itemId) {
    // 선택한 경기 ID를 URL 파라미터로 전송
    if (itemId === 1 || itemId === 2 || itemId === 3 || itemId === 33) {
        location.href = '/inf?itemId=' + itemId;
    } else if (itemId === 4 || itemId === 5 || itemId === 6) {
        location.href = '/inf2?itemId=' + itemId;
    } else if (itemId === 7 || itemId === 8 || itemId === 9) {
        location.href = '/inf3?itemId=' + itemId;
    } else if (itemId === 10 || itemId === 11 || itemId === 12 || itemId === 13) {
        location.href = '/inf4?itemId=' + itemId;
    }
}





