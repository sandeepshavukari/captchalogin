document.addEventListener('DOMContentLoaded', function () {
  const signupForm = document.querySelector('section');
  signupForm.style.opacity = 0;

  setTimeout(() => {
    signupForm.style.transition = 'opacity 1s ease-in-out';
    signupForm.style.opacity = 1;
  }, 500);

  const signupButton = document.querySelector('button');
  signupButton.addEventListener('click', function () {
    const emailInput = document.querySelector('input[type="email"]');
    const passwordInput = document.querySelector('input[type="password"]');
    const confirmPasswordInput = document.querySelector('input[type="password"][name="confirm-password"]');

    const isValid = emailInput.checkValidity() && passwordInput.checkValidity() && confirmPasswordInput.checkValidity();

    if (!isValid) {
      signupForm.classList.add('shake');

      setTimeout(() => {
        signupForm.classList.remove('shake');
      }, 1000);
    }
  });

  // ✅ Forgot Password click handler
  const forgotPasswordLink = document.getElementById('forgotPasswordLink');
  if (forgotPasswordLink) {
    forgotPasswordLink.addEventListener('click', function (e) {
      e.preventDefault();
      window.location.href = "/req/forgot-password"; // redirect to your Spring controller
    });
  }
});
