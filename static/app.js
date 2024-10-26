// Function to display an error message
function showError(message) {
  const container = document.getElementById('contributors-list');
  const errorDiv = document.createElement('div');
  errorDiv.className = 'error';
  errorDiv.innerHTML = `<p>${message}</p>`;
  container.appendChild(errorDiv);
}

// Fetch contributors and display them
async function loadContributors() {
  try {
    const response = await fetch('contributors.json');
    if (!response.ok) throw new Error('Network response was not ok');
    const data = await response.json();
    const container = document.getElementById('contributors-list');
    container.innerHTML = ''; // Clear existing content

    data.forEach(contributor => {
      const div = document.createElement('div');
      div.className = 'contributor';
      div.innerHTML = `<p>${contributor.name}</p><a href="${contributor.github}" target="_blank">GitHub</a>`;
      container.appendChild(div);
    });
  } catch (error) {
    console.error('Error loading contributors:', error);
    showError('Failed to load contributors. Please try again later.');
  }
}

// Automatically refresh contributors every minute
setInterval(loadContributors, 60000); // Fetch contributors every 60 seconds

// Initialize loading contributors on DOMContentLoaded
document.addEventListener('DOMContentLoaded', loadContributors);
