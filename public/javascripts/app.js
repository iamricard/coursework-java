function boot() {
  const app = document.querySelector('#app')

  app.addEventListener('click', evt => {
    const current = document.querySelector('.current')
    const previous = document.querySelector('.previous')

    console.log(current)

    if (current.contains(evt.target) && evt.target.tagName === 'INPUT') {
      const next = current.nextElementSibling
      current.classList.remove('current')
      current.classList.add('previous')

      if (previous) previous.classList.remove('previous')
      if (!next) return

      next.classList.add('current')
    }
  })
}

boot()
