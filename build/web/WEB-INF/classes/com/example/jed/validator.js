/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateForm()
{
    var year = document.forms["book"]["year"].value;
    if (year !== "")
    {
        if (year < 1970)
        {
            alert("Sorry, books published before year 1000 cannot be added to the catalogue.");
            return false;
        }
    }

    var regex = "[0-9]{13}";
    var isbn = document.forms["book"]["isbn"].value;
    var found = isbn.match(regex);

    if (found == null)
    {
        alert("The ISBN format is not valid");
        return false;
    }
}