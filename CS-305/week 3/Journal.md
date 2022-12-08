#The Journal of Glenn Lehman

### My thoughts on DevSecOps: A Systemic Approach for Secure Software Development.

I should start with the "DevOps" pipeline. I have a lot to learn here. DevOps tends to express the concept of automating the building and deployment process. For example, this could include pulling code from GitHub. Then once the code has been modified and you want to push it to the central repo, automated testing occurs first. This process ensures that the new changes do not break the old system.  

This action can then trigger a new build that can go through some additional tests and be ready to push to production. The pipeline can be implemented with products like Jenkins, GitHub actions, Tox, or other tools. The purpose is to speed up deployment and allow the software to be developed using agile sprints. 

Unfortunately, developers tend to focus on functionality and completely forget about security. The article we were asked to review does provide suggestions. The first suggestion is to have a team that focuses on security. While this might work at a larger company, smaller teams will need to have it included by both the product owner and the dev team. I suppose a good scrum master could ensure it is considered. 

I am starting with changing developers' thoughts to consider security while coding and not as an afterthought. Testing will need to change. I believe testing is the gatekeeper. So tests will need to be developed to ensure the software is secure and functional. For example, a test that tries to perform SQL injection would be good to add to a testing suite. 

If specific vulnerabilities are discovered, then custom tests should be added. 

Finally, the project and the associated dependencies must be monitored to ensure that an issue does not sneak in through a dependency. 

Glenn

Afterthought:  None of this works unless a security governance policy is defined, just like functional requirements developers key on specifications for software. 
