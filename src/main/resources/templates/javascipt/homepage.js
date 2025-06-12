// Mobile menu toggle
document.addEventListener("DOMContentLoaded", () => {
  const mobileMenuToggle = document.querySelector(".mobile-menu-toggle")
  const navMenu = document.querySelector(".nav-menu")
  const navActions = document.querySelector(".nav-actions")

  if (mobileMenuToggle) {
    mobileMenuToggle.addEventListener("click", function () {
      this.classList.toggle("active")
      navMenu.classList.toggle("mobile-active")
      navActions.classList.toggle("mobile-active")
    })
  }

  // Dropdown menu functionality
  const dropdownItems = document.querySelectorAll(".nav-item.dropdown")

  dropdownItems.forEach((item) => {
    item.addEventListener("click", function () {
      const menuType = this.getAttribute("data-menu")
      console.log(`Opening ${menuType} menu`)
      // Add dropdown menu logic here
    })
  })

  // Smooth scrolling for navigation
  const navItems = document.querySelectorAll(".nav-item")

  navItems.forEach((item) => {
    item.addEventListener("click", function (e) {
      if (!this.classList.contains("dropdown")) {
        e.preventDefault()
        // Add smooth scrolling logic here
      }
    })
  })

  // Service card interactions
  const serviceCards = document.querySelectorAll(".service-card")

  serviceCards.forEach((card) => {
    card.addEventListener("mouseenter", function () {
      this.style.transform = "translateY(-10px) scale(1.02)"
    })

    card.addEventListener("mouseleave", function () {
      this.style.transform = "translateY(0) scale(1)"
    })
  })

  // Service button clicks
  const serviceButtons = document.querySelectorAll(".service-btn")

  serviceButtons.forEach((button) => {
    button.addEventListener("click", function () {
      const cardType = this.closest(".service-card").classList[1]
      console.log(`Clicked ${cardType} service button`)

      // Add navigation logic based on service type
      switch (cardType) {
        case "business":
          // Navigate to business page
          window.location.href = "/business"
          break
        case "individual":
          // Navigate to individual page
          window.location.href = "/individual"
          break
        case "driver":
          // Navigate to driver registration
          window.location.href = "/driver-signup"
          break
      }
    })
  })

  // Primary CTA button
  const primaryButton = document.querySelector(".btn-primary")

  if (primaryButton) {
    primaryButton.addEventListener("click", () => {
      console.log("Primary CTA clicked")
      // Add booking flow logic here
      window.location.href = "/book-delivery"
    })
  }

  // Login and Register buttons
  const loginButton = document.querySelector(".btn-login")
  const registerButton = document.querySelector(".btn-register")

  if (loginButton) {
    loginButton.addEventListener("click", () => {
      console.log("Login clicked")
      // Add login modal or redirect
      window.location.href = "/login"
    })
  }

  if (registerButton) {
    registerButton.addEventListener("click", () => {
      console.log("Register clicked")
      // Add registration modal or redirect
      window.location.href = "/register"
    })
  }

  // Scroll animations
  const observerOptions = {
    threshold: 0.1,
    rootMargin: "0px 0px -50px 0px",
  }

  const observer = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
      if (entry.isIntersecting) {
        entry.target.style.opacity = "1"
        entry.target.style.transform = "translateY(0)"
      }
    })
  }, observerOptions)

  // Observe service cards for scroll animations
  serviceCards.forEach((card) => {
    card.style.opacity = "0"
    card.style.transform = "translateY(30px)"
    card.style.transition = "opacity 0.6s ease, transform 0.6s ease"
    observer.observe(card)
  })

  // Language selector functionality
  const languageSelector = document.querySelector(".language-selector")

  if (languageSelector) {
    languageSelector.addEventListener("click", () => {
      console.log("Language selector clicked")
      // Add language selection dropdown logic
    })
  }

  // Add parallax effect to hero vehicles
  window.addEventListener("scroll", () => {
    const scrolled = window.pageYOffset
    const vehicles = document.querySelectorAll(".vehicle")

    vehicles.forEach((vehicle, index) => {
      const speed = 0.5 + index * 0.1
      vehicle.style.transform = `translateY(${scrolled * speed}px)`
    })
  })

  // Add loading animation
  window.addEventListener("load", () => {
    document.body.classList.add("loaded")

    // Animate hero text
    const heroText = document.querySelector(".hero-text")
    if (heroText) {
      heroText.style.opacity = "0"
      heroText.style.transform = "translateY(30px)"

      setTimeout(() => {
        heroText.style.transition = "opacity 1s ease, transform 1s ease"
        heroText.style.opacity = "1"
        heroText.style.transform = "translateY(0)"
      }, 300)
    }
  })
})

// Utility functions
function showNotification(message, type = "info") {
  const notification = document.createElement("div")
  notification.className = `notification ${type}`
  notification.textContent = message

  notification.style.cssText = `
        position: fixed;
        top: 20px;
        right: 20px;
        padding: 15px 20px;
        background: ${type === "success" ? "#4CAF50" : type === "error" ? "#f44336" : "#2196F3"};
        color: white;
        border-radius: 4px;
        z-index: 10000;
        opacity: 0;
        transform: translateX(100%);
        transition: all 0.3s ease;
    `

  document.body.appendChild(notification)

  setTimeout(() => {
    notification.style.opacity = "1"
    notification.style.transform = "translateX(0)"
  }, 100)

  setTimeout(() => {
    notification.style.opacity = "0"
    notification.style.transform = "translateX(100%)"
    setTimeout(() => {
      document.body.removeChild(notification)
    }, 300)
  }, 3000)
}

// Form validation helper
function validateForm(formData) {
  const errors = []

  if (!formData.email || !formData.email.includes("@")) {
    errors.push("Email không hợp lệ")
  }

  if (!formData.phone || formData.phone.length < 10) {
    errors.push("Số điện thoại không hợp lệ")
  }

  return errors
}

// API helper functions
async function makeAPICall(endpoint, method = "GET", data = null) {
  try {
    const options = {
      method,
      headers: {
        "Content-Type": "application/json",
      },
    }

    if (data) {
      options.body = JSON.stringify(data)
    }

    const response = await fetch(endpoint, options)

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`)
    }

    return await response.json()
  } catch (error) {
    console.error("API call failed:", error)
    showNotification("Có lỗi xảy ra, vui lòng thử lại", "error")
    throw error
  }
}
