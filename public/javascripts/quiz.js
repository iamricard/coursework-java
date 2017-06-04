function boot() {
  const app = document.querySelector('#app')

  app.addEventListener('click', evt => {
    const current = document.querySelector('.current')
    const form = document.querySelector('form')

    if (current.contains(evt.target) && evt.target.tagName === 'INPUT') {
      const next = current.nextElementSibling

      if (!next) {
        form.submit()
      } else {
        current.classList.remove('current')
        next.classList.add('current')
      }
    }
  })
}

function skipQ(el) {
  const question = el.parentNode
  const nextQuestion = question.nextElementSibling
  const form = question.parentNode

  question.classList.remove('current')
  question.removeChild(el)
  nextQuestion.classList.add('current')

  form.appendChild(question)
}

boot()
