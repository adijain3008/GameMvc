<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Player</title>
</head>
<body>
	<form action="addPlayer" method="post">
		<fieldset>
			<table>
				<tr>
					<td>Player Id:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td class="select">Player Type
					<select name="type">
							<option value="Batsman">Batsman</option>
							<option value="Bowler">Bowler</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>Batting Avg.:</td>
					<td><input type="text" name="battingAvg"></td>
				</tr>
				<tr>
					<td>Bowling Avg.:</td>
					<td><input type="text" name="bowlingAvg"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Confirm & Checkout"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>