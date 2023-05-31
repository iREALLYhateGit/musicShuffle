<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Here it is</title>
</head>
<body>
<h1>
    Sorted playlist, here you are
</h1>
<h6>
</h6>
<table>
    <tr>
        <th>
            id
        </th>
        <th>
            name
        </th>
        <th>
            author
        </th>
        <th>
            genre
        </th>
        <th>
            duration
        </th>
    </tr>
    <#list tracks as track>
        <tr>
            <td>
                ${track.id}
            </td>
            <td>
                ${track.trackName}
            </td>
            <td>
                ${track.author.name} ${track.author.surname}
            </td>
            <td>
                ${track.genre}
            </td>
            <td>
                ${track.duration}
            </td>
        </tr>
    </#list>
    </tr>
</table>
<h6>
</h6>
<h1>
    The end of the playlist
</h1>
</body>
</html>