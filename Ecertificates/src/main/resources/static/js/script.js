  const maxRows = 10; // Maximum rows to display per page
        let currentPage = 1;

        // Function to display eCert in the table
        function displayEcert(certificates) {
            const ecertList = document.getElementById('ecertList');
            ecertList.innerHTML = '';

            const startIndex = (currentPage - 1) * maxRows;
            const endIndex = currentPage * maxRows;

            for (let i = startIndex; i < endIndex && i < certificates.length; i++) {
                const eCert = certificates[i];
                const row = document.createElement('tr');
                row.innerHTML = `
                	<td>${eCert.RowNumber}</td>
                    <td>${eCert.serialNumber}</td>
                    <td>${eCert.Email}</td>
                    <td>${eCert.CN}</td>
                    <td>${eCert.C}</td>
                    <td>${eCert.O}</td>
                    <td>${eCert.OU}</td>
                    <td>${eCert.telephoneNumber}</td>
                    <td>${eCert.ST}</td>
                    <td>${eCert.SignatureAlgorithm}</td>
                    <td>${eCert.SignatureParameters}</td>
                    <td>${eCert.Signature}</td>
                  
                    <td>
	                    <button onclick="editEcert('${eCert.serialNumber}')">Edit</button>
	        			<button onclick="deleteEcert('${eCert.serialNumber}')">Delete</button>
                    
                    
                    
                   
                    </td>
                `;
                
                ecertList.appendChild(row);
                 
            }
        }

        // Function to search for a book by ID
        function searchEcert() {
            const newNo = document.getElementById('searchSerialNumber').value
			console.log("Searched no:"+newNo);
			fetch(`/getCert/${newNo}`)
                .then(response => response.json())
                .then(data => {
					//console.log(data); // Log the contents of the 'data' object to the console.

                    if (data.statusCode === 1 && data.message === 'E-certificate details found!' && data.cert) {
		                const certData = data.cert;
		                document.getElementById('searchResult').innerText = `Found Cert: ID: ${certData.serialNumber}, 
		                Email: ${certData.Email}, Common Name: ${certData.CN},
		                Country: ${certData.C},Organization: ${certData.O},
		                Organizational Unit: ${certData.OU},Telephone Number:${certData.telephoneNumber},
		                State:${certData.ST},Signature Algorithm:${certData.SignatureAlgorithm},
		                Signature Parameters:${certData.SignatureParameters},
		                Signature:${certData.Signature}`;
		                console.log("E-Certificate found");
		            } else {
		                console.log(data); // Log the contents of the 'data' object to the console.
		                document.getElementById('searchResult').innerText = 'E-certifiacte not found.';
		            }
		                })
                .catch(error => {
                    console.error("Error searching for Certifiacte:", error);
                });
        }

        // Function to add a new book
        document.getElementById('addEcert').addEventListener('submit', function (e) {
            e.preventDefault();
            const newSN = document.getElementById('newSN').value;
            const newEmail = document.getElementById('newEmail').value;
            const newCN = document.getElementById('newCN').value;
            const newC = document.getElementById('newC').value;
            const newO = document.getElementById('newO').value;
            const newOU = document.getElementById('newOU').value;
            const newtelephoneNumber = document.getElementById('newtelephoneNumber').value;
            const newST = document.getElementById('newST').value;
            const newSignatureAlgorithm = document.getElementById('newSignatureAlgorithm').value;
            const newSignatureParameters = document.getElementById('newSignatureParameters').value;
            const newSignature = document.getElementById('newSignature').value;
           
            document.addEventListener("DOMContentLoaded", function() {
		    const form = document.getElementById("addEcert");
		
		    form.addEventListener("submit", function(event) {
		      event.preventDefault(); // Prevent the form from actually submitting
		
			      // Reset the form fields
			      form.reset();
			    });
			  });

            // Make an AJAX request to add a new book using the Spring Boot controller
            fetch('/createCert', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
					
					serialNumber: newSN,
			        Email: newEmail,
			        CN: newCN,
			        C:newC,
			        O:newO,
			        OU:newOU,
			        telephoneNumber:newtelephoneNumber,
			        ST:newST,
			        SignatureAlgorithm:newSignatureAlgorithm,
			        SignatureParameters:newSignatureParameters,
			        Signature:newSignature
					
					
                    
                })
            })
                .then(response => response.json())
                .then(data => {
                    if (data === true) {
                        // Book added successfully, refresh the book list
                        fetchecertList();
                         
                    } else {
                        console.error("Error adding E-Cert:", data);
                    }
                })
                .catch(error => {
                    console.error("Error adding E-cert:", error);
                });
        });

        // Function to delete deleteEcert(${eCert.serialNumber}
        function deleteEcert(serialNumber) {
			console.log('deleting eCert:', serialNumber);
			const confirmation = confirm("Are you sure you want to delete this certificate?");
		    if (confirmation) {
		        fetch(`/delCert/${serialNumber}`, {
		            method: 'GET'
		        })
		        .then(response => response.json())
		        .then(data => {
		            if (data === true) {
		                fetchecertList(); // Refresh the certificate list after deletion
		            } else {
		                console.error("Error deleting E-cert", data);
		            }
		        })
		        .catch(error => {
		            console.error("Error deleting E-cert:", error);
		        });
		    }
        }

        

        // Function to fetch the book list
        let eCert = [];
        function fetchecertList() {
            // Make an AJAX request to retrieve the list of eCert from the Spring Boot controller
            fetch('/list')
                .then(response => response.json())
                .then(data => {
                    // Display the list of eCert
                     eCert = data;
                    displayEcert(data);
                })
                .catch(error => {
                    console.error("Error fetching E-Cert list:", error);
                });
        }

        // Function to navigate to the previous page
        function prevPage() {
            if (currentPage > 1) {
                currentPage--;
                displayEcert(eCert);
            }
        }

        // Function to navigate to the next page
        function nextPage() {
            const totalPages = Math.ceil(eCert.length / maxRows);
            if (currentPage < totalPages) {
                currentPage++;
                displayEcert(eCert);
            }
        }
        
        //editEcert(${eCert.serialNumber}
        // Function to open the edit form and populate it with book details
    function editEcert(SerNo) {
		console.log('Editing eCert:', SerNo);
        const Ecert = eCert.find(b => b.serialNumber === SerNo);
        if (Ecert) {
            document.getElementById('editSN').value = Ecert.serialNumber;
            document.getElementById('editEmail').value = Ecert.Email;
            document.getElementById('editCN').value = Ecert.CN;
            document.getElementById('editC').value = Ecert.C;
            document.getElementById('editO').value = Ecert.O;
            document.getElementById('editOU').value = Ecert.OU;
            document.getElementById('edittelephoneNumber').value = Ecert.telephoneNumber;
            document.getElementById('editST').value = Ecert.ST;
            document.getElementById('editSignatureAlgorithm').value = Ecert.SignatureAlgorithm;
            document.getElementById('editSignatureParameters').value = Ecert.SignatureParameters;
            document.getElementById('editSignature').value = Ecert.Signature;             
            document.getElementById('editEcert').style.display = 'block';
        }
    }

    // Function to save edited book details
    function saveEditedCert() {
        const editedId = document.getElementById('editSN').value;
        const editedEmail = document.getElementById('editEmail').value;
        const editedCN = document.getElementById('editCN').value;
        const editedC = document.getElementById('editC').value;
        const editedO = document.getElementById('editO').value;
        const editedOU = document.getElementById('editOU').value;
        const editedtelephoneNumber = document.getElementById('edittelephoneNumber').value;
        const editedST = document.getElementById('editST').value;
        const editedSignatureAlgorithm = document.getElementById('editSignatureAlgorithm').value;
        const editedSignatureParameters = document.getElementById('editSignatureParameters').value;
        const editedSignature = document.getElementById('editSignature').value;        

        // Make an AJAX request to save the edited book using the Spring Boot controller
        fetch('/updateCert', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                serialNumber: editedId,
			        Email: editedEmail,
			        CN: editedCN,
			        C:editedC,
			        O:editedO,
			        OU:editedOU,
			        telephoneNumber:editedtelephoneNumber,
			        ST:editedST,
			        SignatureAlgorithm:editedSignatureAlgorithm,
			        SignatureParameters:editedSignatureParameters,
			        Signature:editedSignature
            })
        })
            .then(response => response.json())
            .then(data => {
				
				console.log("hahaha"+data);
                if (data === true) {
                    // Book details saved successfully
                    document.getElementById('confirmationPopup').style.display = 'block';
                } else {
                    console.error("Error saving E-Cert details:", data);
                }
            })
            .catch(error => {
                console.error("Error saving E-cert details:", error);
            });
    }

    // Function to close the confirmation popup and refresh the page
    function closePopup() {
        document.getElementById('confirmationPopup').style.display = 'none';
        document.getElementById('editEcert').style.display = 'none';
        fetchecertList(); // Refresh the book list
    }

        // Display eCert when the page loads
        fetchecertList();