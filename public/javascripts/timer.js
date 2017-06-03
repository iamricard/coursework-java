function go() {
  const now = () => (new Date()).getTime()
  const pad = (n) => '00'.substr(0, 2 - n.toString().length) + n

  const timer = document.querySelector('#timer span')
  const questions = document.querySelectorAll('.question').length
  const total = questions * 60000
  const start = now()
  let interval

  function tick() {
    const elapsed = now() - start
    const left = total - elapsed
    const seconds = Math.floor((left / 1000) % 60)
    const minutes = Math.floor((left / 1000 / 60) % 60)

    if (left > 0) {
      timer.innerHTML = `${pad(minutes)}:${pad(seconds)}`
    } else {
      clearInterval(interval)
      document.querySelector('form').submit()
    }
  }

  function startTimer() {
    clearInterval(interval)
    interval = setInterval(tick, 500)
  }

  startTimer()
}

go()
