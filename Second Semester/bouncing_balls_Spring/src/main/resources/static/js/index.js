function repeatBall(ball, count, deep) {
    for (var i = 0, copy; i < count - 1; i++) {
        copy = ball.cloneNode(deep);
        ball.parentNode.insertBefore(copy, ball);
    }
}

repeatBall(document.querySelector('.ball-wrapper'), 6, true);

function repeatFootBall(ball, count, deep) {
    for (var i = 0, copy; i < count - 1; i++) {
        copy = ball.cloneNode(deep);
        ball.parentNode.insertBefore(copy, ball);
    }
}

repeatFootBall(document.querySelector('.ball-wrapper1'), 6, true);