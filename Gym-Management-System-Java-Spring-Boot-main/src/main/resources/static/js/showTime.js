function showTime() {
    var date = new Date();
    var dayOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][date.getDay()];
    var day = ('0' + date.getDate()).slice(-2);
    var month = ('0' + (date.getMonth() + 1)).slice(-2);
    var year = date.getFullYear();
    var hours = ('0' + ((date.getHours() % 12) || 12)).slice(-2);
    var minutes = ('0' + date.getMinutes()).slice(-2);
    var seconds = ('0' + date.getSeconds()).slice(-2);
    var suffix = date.getHours() >= 12 ? 'PM' : 'AM';

    var currentDateTime = dayOfWeek + ', ' + hours + ':' + minutes + ':' + seconds + ' ' + suffix;

    document.getElementById('current-time').innerText = currentDateTime;

    setTimeout(showTime, 1000);
}

window.onload = function () {
    showTime();
};