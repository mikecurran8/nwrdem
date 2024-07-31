<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>NWR Jobs Insert</title>
      <link rel="stylesheet" href="style.css">
  </head>
  <style>
   fieldset {
     background-color: #eeeeee;
   }

   legend {
     background-color: gray;
     color: white;
     padding: 5px 10px;
   }

   input {
     margin: 5px;
   }
   table, th, td {
     border: 1px solid black;
     border-collapse: collapse;
   }
  </style>
  <body>
  <table>
    <form action="InsertJobsServlet" method="post">
      <legend>Insert Job Details</legend>
         <tr>	 
		<td><label for="lotNumber">Lot Number: </label></td>
		<td><input type="text" name="lotNumber" placeholder="lot numbers only, ex 47" required  autofocus/></td>
		<td><label for="locationId">Location Id: </label></td>
		<td><input type="text" name="locationId" placeholder="location id, ex JER" required / ></td>
		<td><label for="permitNumber" >Permit Number: </label></td>
		<td><input type="text" name="permitNumber" placeholder="permit number, ex RR-22-1117" required /></td>
	</tr>
	<tr>
		<td><label>Phase</label></td>
		<td><label>Builder Date</label></td>
		<td><label>Start Date</label></td>
		<td><label>Completed Date</label></td>
		<td><label>Inspection Requested Date</label></td>
		<td><label>Results</label></td>
		<td><label>Notes</label></td>
	</tr>
	<tr>
		<td><label>Underground</label></td>
		<td><input type="text" name="uBuilderDate" placeholder="Date" /></td>
		<td><input type="text" name="uStartDate" placeholder="Date" /></td>
		<td><input type="text" name="uCompletedDate" placeholder="Date" /></td>
		<td><input type="text" name="uInspectionDate" placeholder="Date" /></td>
		<td><input type="text" name="uResults" placeholder="Pass or Fail" /></td>
		<td><textarea name="notes" id="uNotes" rows="4" columns="50">This is for notes</textarea>
	</tr>
	<tr>
		<td><label>Rough</label></td>
		<td><input type="text" name="rBuilderDate" placeholder="Date" /></td>
		<td><input type="text" name="rStartDate" placeholder="Date" /></td>
		<td><input type="text" name="rCompletedDate" placeholder="Date" /></td>
		<td><input type="text" name="rInspectionDate" placeholder="Date" /></td>
		<td><input type="text" name="rResults" placeholder="Pass or Fail" /></td>
		<td><textarea name="notes" id="rNotes" rows="4" columns="50">This is for notes</textarea>
	</tr>
        <tr>  
                <td><label>Finish</label></td>
                <td><input type="text" name="fBuilderDate" placeholder="Date" /></td>
                <td><input type="text" name="fStartDate" placeholder="Date" /></td>
		<td><input type="text" name="fCompletedDate" placeholder="Date" /></td>
                <td><input type="text" name="fInspectionDate" placeholder="Date" /></td>
                <td><input type="text" name="fResults" placeholder="Pass or Fail" /></td>
                <td><textarea name="notes" id="fNotes" rows="4" columns="50">This is for notes</textarea>
        </tr>
        <tr>  
                <td><label>Punch</label></td>
                <td><input type="text" name="pBuilderDate" placeholder="Date" /></td>
                <td><input type="text" name="pStartDate" placeholder="Date" /></td>
		<td><input type="text" name="pCompletedDate" placeholder="Date" /></td>
                <td><input type="text" name="pInspectionDate" placeholder="Date" /></td>
                <td><input type="text" name="pResults" placeholder="Pass or Fail" /></td>
                <td><textarea name="notes" id="pNotes" rows="4" columns="50">This is for notes</textarea>
        </tr>
	
              <input type="submit" value="Insert Job"/>
    </form>
  </table>
  </body>
</html>
