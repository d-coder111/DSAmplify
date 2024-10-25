document.addEventListener('DOMContentLoaded', () => {
    const table = document.getElementById('tableforcontributors');

    const repoOwner = 'd-coder111';
    const repoName = 'DSAmplify';

    // here enter your access toket
    const accessToken = "[ here enter your access token ]";

    fetch(`https://api.github.com/repos/${repoOwner}/${repoName}/contributors`, {
        headers: {
            'Authorization': `token ${accessToken}`
        }
    })
        .then(response => response.json())
        .then(contributors => {
            let serialNumber = 1;
            contributors.forEach(contributor => {
                const row = table.insertRow();

                const cell1 = row.insertCell(0);
                cell1.textContent = serialNumber;

                const cell2 = row.insertCell(1);
                cell2.textContent = contributor.login;

                fetch(`https://api.github.com/repos/${repoOwner}/${repoName}/commits?author=${contributor.login}`, {
                    headers: {
                        'Authorization': `token ${accessToken}`
                    }
                })
                    .then(response => response.json())
                    .then(commits => {
                        const cell3 = row.insertCell(2);
                        cell3.textContent = commits.length;
                        const lastCommitDate = new Date(commits[0].commit.author.date);
                        const cell4 = row.insertCell(3);
                        cell4.textContent = lastCommitDate.toDateString();
                    })
                    .catch(error => {
                        console.error('Error fetching contribution data: ', error);
                    });

                serialNumber++;
            });
        })
        .catch(error => {
            console.error('Error fetching contributors: ', error);
        });
});