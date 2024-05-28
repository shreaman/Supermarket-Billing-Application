let second = 0;
const oneMin = 60;
const timer = document.getElementById('timer');

const timeInterval = setInterval(() => {
    second++;
    const minute = Math.floor(second/oneMin);
    const seconds = second % oneMin;
    timer.textContent = `${String(minute).padStart(2, '0')}:${String(seconds).padStart(2, '0')}`;
    if (minute >= 5) {
        clearInterval(timeInterval);
        timer.textContent = "Time's up!";
    }
},1000);