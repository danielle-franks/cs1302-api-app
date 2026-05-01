# Deadline

Modify this file to satisfy a submission requirement related to the project
deadline. Please keep this file organized using Markdown. If you click on
this file in your GitHub repository website, then you will see that the
Markdown is transformed into nice-looking HTML.

## Part 1.1: App Description

> Please provide a friendly description of your app, including the
> primary functions available to users of the app. Be sure to describe
> exactly what APIs two you are using and how they relate to your
> custom components.

> **Also, include the GitHub `https` URL to your repository.**

This app allows the user to search for a song using the Itunes API, featured on the Itunes component
on the left side of the app. They can click on a song
to view its details, such as artist, album, and duration. The user can click the "Use this song
for lyrics" button to automatically copy the relevant information to the Lyrics component(right side of the app), which uses the
LRCLIB API. From there they can click the "Get lyrics" button to view the lyrics of the song, if available. Alternatively, the user
can choose to manually enter the information of a song into the fields of the Lyrics component, if they don't want/need to
look it up on Itunes. They can also choose to only search for a song on Itunes, and not view its lyrics; the APIs can be used together or independently.

https://github.com/danielle-franks/cs1302-api-app

## Part 1.2: APIs

> For each RESTful JSON API that your app uses (at least two are
> required), include an example URL for a typical request made by your
> app as well as an example of a typical response in JSON. If you need
> to include additional notes (e.g., regarding API keys or rate
> limits), then you can do that below the URL/URI. Placeholders for
> this information are provided below. If your app uses more than two
> RESTful JSON APIs, then include them with similar formatting.

### API 1

```
https://.../replace/me

https://itunes.apple.com/search?term=sick+love&limit=10&media=music&entity=song
```

```json
{ replace with json }

{
 "resultCount":10,
 "results": [
{"wrapperType":"track", "kind":"song", "artistId":889780, "collectionId":1109250450, "trackId":1109251513, "artistName":"Red Hot Chili Peppers", "collectionName":"The Getaway", "trackName":"Sick Love", "collectionCensoredName":"The Getaway", "trackCensoredName":"Sick Love", "artistViewUrl":"https://music.apple.com/us/artist/red-hot-chili-peppers/889780?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/1109250450?i=1109251513&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/1109250450?i=1109251513&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview115/v4/9e/2a/4e/9e2a4e26-1d9e-a8e1-4e72-ebbca85a1ce7/mzaf_10667817255464942916.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/22/3e/ed/223eedeb-3ad1-2bd8-c863-ab6fb39d658a/093624920137.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/22/3e/ed/223eedeb-3ad1-2bd8-c863-ab6fb39d658a/093624920137.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/22/3e/ed/223eedeb-3ad1-2bd8-c863-ab6fb39d658a/093624920137.jpg/100x100bb.jpg", "collectionPrice":11.99, "trackPrice":1.29, "releaseDate":"2016-06-17T07:00:00Z", "collectionExplicitness":"notExplicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":13, "trackNumber":6, "trackTimeMillis":221453, "country":"USA", "currency":"USD", "primaryGenreName":"Alternative", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":889780, "collectionId":1681797616, "trackId":1681798291, "artistName":"Red Hot Chili Peppers", "collectionName":"10s Lost & Found", "trackName":"Sick Love", "collectionCensoredName":"10s Lost & Found", "trackCensoredName":"Sick Love", "collectionArtistId":151566958, "collectionArtistName":"Various Artists", "artistViewUrl":"https://music.apple.com/us/artist/red-hot-chili-peppers/889780?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/1681797616?i=1681798291&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/1681797616?i=1681798291&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview126/v4/30/dc/e7/30dce73c-5227-2654-ebbf-054884913b89/mzaf_5778610518907204703.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/cd/ff/22/cdff2281-ffdb-37c9-259c-154b7a889ff9/5059460191310.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/cd/ff/22/cdff2281-ffdb-37c9-259c-154b7a889ff9/5059460191310.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/cd/ff/22/cdff2281-ffdb-37c9-259c-154b7a889ff9/5059460191310.jpg/100x100bb.jpg", "releaseDate":"2016-06-17T12:00:00Z", "collectionExplicitness":"explicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":70, "trackNumber":24, "trackTimeMillis":221440, "country":"USA", "currency":"USD", "primaryGenreName":"Alternative", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":889780, "collectionId":1807510234, "trackId":1807511940, "artistName":"Red Hot Chili Peppers", "collectionName":"Acadia National Park – Coastal Tunes", "trackName":"Sick Love", "collectionCensoredName":"Acadia National Park – Coastal Tunes", "trackCensoredName":"Sick Love", "collectionArtistId":151566958, "collectionArtistName":"Various Artists", "artistViewUrl":"https://music.apple.com/us/artist/red-hot-chili-peppers/889780?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/1807510234?i=1807511940&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/1807510234?i=1807511940&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview221/v4/cc/d0/90/ccd090bd-9a00-0a62-d6bf-abaa79670b19/mzaf_10484551492127109127.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music211/v4/df/a5/f1/dfa5f1f8-29a9-db87-a1b1-d6270f6f5e27/5059460390126.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music211/v4/df/a5/f1/dfa5f1f8-29a9-db87-a1b1-d6270f6f5e27/5059460390126.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music211/v4/df/a5/f1/dfa5f1f8-29a9-db87-a1b1-d6270f6f5e27/5059460390126.jpg/100x100bb.jpg", "releaseDate":"2016-06-17T12:00:00Z", "collectionExplicitness":"explicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":40, "trackNumber":28, "trackTimeMillis":221440, "country":"USA", "currency":"USD", "primaryGenreName":"Alternative", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":15621603, "collectionId":943172484, "trackId":943172509, "artistName":"Ektomorf", "collectionName":"Black Flag", "trackName":"Sick Love", "collectionCensoredName":"Black Flag", "trackCensoredName":"Sick Love", "artistViewUrl":"https://music.apple.com/us/artist/ektomorf/15621603?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/943172484?i=943172509&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/943172484?i=943172509&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview125/v4/a6/0d/89/a60d8945-00d3-19da-c894-64f005fc9c49/mzaf_3850878187178717490.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music3/v4/4a/5d/83/4a5d836d-645b-39dd-d65e-f821f2fa7cb1/cover.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music3/v4/4a/5d/83/4a5d836d-645b-39dd-d65e-f821f2fa7cb1/cover.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music3/v4/4a/5d/83/4a5d836d-645b-39dd-d65e-f821f2fa7cb1/cover.jpg/100x100bb.jpg", "releaseDate":"2012-08-31T12:00:00Z", "collectionExplicitness":"explicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":13, "trackNumber":11, "trackTimeMillis":207520, "country":"USA", "currency":"USD", "primaryGenreName":"Metal", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":1182243801, "collectionId":1642334629, "trackId":1642334634, "artistName":"LOONA", "collectionName":"LUMINOUS - Single", "trackName":"SICK LOVE", "collectionCensoredName":"LUMINOUS - Single", "trackCensoredName":"SICK LOVE", "artistViewUrl":"https://music.apple.com/us/artist/loona/1182243801?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/1642334629?i=1642334634&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/1642334629?i=1642334634&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview112/v4/c2/25/2e/c2252e0c-cb07-0c02-0e49-d8b63b3e60e3/mzaf_10470053199601121985.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/01/8e/8b/018e8bb2-c0b2-9fc3-f8bb-b69f231e9987/22UMGIM92877.rgb.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/01/8e/8b/018e8bb2-c0b2-9fc3-f8bb-b69f231e9987/22UMGIM92877.rgb.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/01/8e/8b/018e8bb2-c0b2-9fc3-f8bb-b69f231e9987/22UMGIM92877.rgb.jpg/100x100bb.jpg", "collectionPrice":2.99, "trackPrice":1.29, "releaseDate":"2022-09-05T12:00:00Z", "collectionExplicitness":"notExplicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":3, "trackNumber":2, "trackTimeMillis":217400, "country":"USA", "currency":"USD", "primaryGenreName":"K-Pop", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":1464854844, "collectionId":1494374023, "trackId":1494374028, "artistName":"Bj Rodriguez", "collectionName":"Pretty Dark", "trackName":"Sick Love", "collectionCensoredName":"Pretty Dark", "trackCensoredName":"Sick Love", "artistViewUrl":"https://music.apple.com/us/artist/bj-rodriguez/1464854844?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/1494374023?i=1494374028&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/1494374023?i=1494374028&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview115/v4/5d/15/de/5d15de81-3a00-6cff-df07-aa8ac2b3f518/mzaf_5819390282972185867.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music113/v4/ea/1b/90/ea1b90e6-dd06-2bd0-c19e-a15a213fb562/artwork.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music113/v4/ea/1b/90/ea1b90e6-dd06-2bd0-c19e-a15a213fb562/artwork.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music113/v4/ea/1b/90/ea1b90e6-dd06-2bd0-c19e-a15a213fb562/artwork.jpg/100x100bb.jpg", "collectionPrice":5.99, "trackPrice":0.99, "releaseDate":"2020-02-14T12:00:00Z", "collectionExplicitness":"notExplicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":9, "trackNumber":5, "trackTimeMillis":285240, "country":"USA", "currency":"USD", "primaryGenreName":"Alternative", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":72701884, "collectionId":1439641773, "trackId":1439641780, "artistName":"Scanners", "collectionName":"Submarine", "trackName":"Sick Love", "collectionCensoredName":"Submarine", "trackCensoredName":"Sick Love", "artistViewUrl":"https://music.apple.com/us/artist/scanners/72701884?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/1439641773?i=1439641780&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/1439641773?i=1439641780&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview115/v4/29/90/9b/29909b51-ecdf-9ea9-106c-0c425b075c4b/mzaf_16158065426516192362.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music128/v4/b0/40/9c/b0409ce7-eb2d-ef65-9007-dbab235a8527/843436061876.png/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music128/v4/b0/40/9c/b0409ce7-eb2d-ef65-9007-dbab235a8527/843436061876.png/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music128/v4/b0/40/9c/b0409ce7-eb2d-ef65-9007-dbab235a8527/843436061876.png/100x100bb.jpg", "collectionPrice":9.99, "trackPrice":1.29, "releaseDate":"2005-07-02T12:00:00Z", "collectionExplicitness":"notExplicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":11, "trackNumber":5, "trackTimeMillis":210963, "country":"USA", "currency":"USD", "primaryGenreName":"Rock", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":1182243801, "collectionId":1641655312, "trackId":1641655458, "artistName":"LOONA", "collectionName":"SICK LOVE - Single", "trackName":"SICK LOVE", "collectionCensoredName":"SICK LOVE - Single", "trackCensoredName":"SICK LOVE", "artistViewUrl":"https://music.apple.com/us/artist/loona/1182243801?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/1641655312?i=1641655458&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/1641655312?i=1641655458&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview122/v4/46/1e/54/461e5470-1f2e-c8a3-5c66-795406282a82/mzaf_4362446384852018816.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/88/56/a0/8856a04d-2f44-777e-2085-fa18cd7f93db/22UMGIM92875.rgb.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/88/56/a0/8856a04d-2f44-777e-2085-fa18cd7f93db/22UMGIM92875.rgb.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/88/56/a0/8856a04d-2f44-777e-2085-fa18cd7f93db/22UMGIM92875.rgb.jpg/100x100bb.jpg", "collectionPrice":1.29, "trackPrice":1.29, "releaseDate":"2022-09-05T12:00:00Z", "collectionExplicitness":"notExplicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":1, "trackNumber":1, "trackTimeMillis":217400, "country":"USA", "currency":"USD", "primaryGenreName":"K-Pop", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":1441226831, "collectionId":1490651445, "trackId":1490651447, "artistName":"Crown", "collectionName":"Sick Love - Single", "trackName":"Sick Love", "collectionCensoredName":"Sick Love - Single", "trackCensoredName":"Sick Love", "artistViewUrl":"https://music.apple.com/us/artist/crown/1441226831?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love/1490651445?i=1490651447&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love/1490651445?i=1490651447&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview126/v4/ad/a3/5d/ada35ddf-7fc8-53d9-8e78-0ce0169914e5/mzaf_16562357134266749363.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music113/v4/38/21/70/3821702c-03f6-a902-b27f-2af80d03e2e7/artwork.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music113/v4/38/21/70/3821702c-03f6-a902-b27f-2af80d03e2e7/artwork.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music113/v4/38/21/70/3821702c-03f6-a902-b27f-2af80d03e2e7/artwork.jpg/100x100bb.jpg", "collectionPrice":0.99, "trackPrice":0.99, "releaseDate":"2020-01-10T12:00:00Z", "collectionExplicitness":"notExplicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":1, "trackNumber":1, "trackTimeMillis":178994, "country":"USA", "currency":"USD", "primaryGenreName":"Pop", "isStreamable":true},
{"wrapperType":"track", "kind":"song", "artistId":371979396, "collectionId":1186856474, "trackId":1186856717, "artistName":"Sasha Lopez", "collectionName":"Sick Love (feat. Evan) - Single", "trackName":"Sick Love (feat. Evan)", "collectionCensoredName":"Sick Love (feat. Evan) - Single", "trackCensoredName":"Sick Love (feat. Evan)", "artistViewUrl":"https://music.apple.com/us/artist/sasha-lopez/371979396?uo=4", "collectionViewUrl":"https://music.apple.com/us/album/sick-love-feat-evan/1186856474?i=1186856717&uo=4", "trackViewUrl":"https://music.apple.com/us/album/sick-love-feat-evan/1186856474?i=1186856717&uo=4",
"previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview125/v4/da/79/2c/da792c1a-d71b-a716-e605-dfbd595a65f4/mzaf_13726419173012750339.plus.aac.p.m4a", "artworkUrl30":"https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/68/14/0c/68140c52-026a-dfd0-17ba-dcc93d1711d0/cover.jpg/30x30bb.jpg", "artworkUrl60":"https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/68/14/0c/68140c52-026a-dfd0-17ba-dcc93d1711d0/cover.jpg/60x60bb.jpg", "artworkUrl100":"https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/68/14/0c/68140c52-026a-dfd0-17ba-dcc93d1711d0/cover.jpg/100x100bb.jpg", "collectionPrice":1.29, "trackPrice":1.29, "releaseDate":"2015-02-10T12:00:00Z", "collectionExplicitness":"notExplicit", "trackExplicitness":"notExplicit", "discCount":1, "discNumber":1, "trackCount":1, "trackNumber":1, "trackTimeMillis":222222, "country":"USA", "currency":"USD", "primaryGenreName":"Dance", "isStreamable":true}]
}



```
> Replace this line with notes (if needed) or remove it (if not needed).

### API 2

```
https://../replace/me

https://lrclib.net/api/get?artist_name=Red+Hot+Chili+Peppers&track_name=Sick+Love&album_name=The+Getaway&duration=221
```

```json
{ replace with json }


{"id":1049219,"name":"Sick Love","trackName":"Sick Love","artistName":"Red Hot Chili Peppers","albumName":"The Getaway","duration":221.0,"instrumental":false,"plainLyrics":"Say goodbye to Oz and everything you own\nCalifornia dreamin' is a Pettibon\nLA's screaming you're my home\nVanity is blasted but it's rarely fair\nI could smell the Prozac in your pretty hair\nGot a lot of friends, but is anyone there\n\nI don't know but it's been said\nYour heart is stronger than your head\nAnd this location is my home\n\nStick n move you're living in a quick world\nGot a heavy laugh for such a tiny girl\nBorn into it that's for sure\n\nRivers get connected so much stronger than expected well\nSick love comes to wash us away\nPrisons of perspective\nHow your vision gets corrected and\nSick love is my modern cliche\n\nPeople talk and tell you what you want to hear\nDo you really need another souvenir\nSuper heroes tend to disappear\nFame is just a trick you see an empty glass\nLeave you feeling thirsty and so very fast\nChase your tail my baby it'll be your last\n\nI don't know but it's been said\nYour heart is stronger than your head\nAnd this location is my home\n\nRivers get connected so much stronger than expected well\nSick love comes to wash us away\nPrisons of perspective\nHow your vision gets corrected and\nSick love is my modern cliche\n\nRivers get connected so much stronger than expected well\nSick love comes to wash us away\nPrisons of perspective\nHow your vision gets corrected and\nSick love is my modern cliche\n\nOpenly defective is the lover you elected and\nA portrait she was bound to portray","syncedLyrics":"[00:14.76] Say goodbye to Oz and everything you own\n[00:18.29] California dreamin' is a Pettibon\n[00:21.47] LA's screaming you're my home\n[00:27.75] Vanity is blasted but it's rarely fair\n[00:31.18] I could smell the Prozac in your pretty hair\n[00:34.24] Got a lot of friends, but is anyone there\n[00:40.82] I don't know but it's been said\n[00:44.32] Your heart is stronger than your head\n[00:47.68] And this location is my home\n[00:53.87] Stick n move you're living in a quick world\n[00:57.24] Got a heavy laugh for such a tiny girl\n[01:00.56] Born into it that's for sure\n[01:06.75] Rivers get connected so much stronger than expected well\n[01:13.14] Sick love comes to wash us away\n[01:19.40] Prisons of perspective\n[01:22.36] How your vision gets corrected and\n[01:25.91] Sick love is my modern cliche\n[01:31.17] People talk and tell you what you want to hear\n[01:34.53] Do you really need another souvenir\n[01:37.88] Super heroes tend to disappear\n[01:43.81] Fame is just a trick you see an empty glass\n[01:47.54] Leave you feeling thirsty and so very fast\n[01:50.72] Chase your tail my baby it'll be your last\n[01:57.01] I don't know but it's been said\n[02:00.56] Your heart is stronger than your head\n[02:04.06] And this location is my home\n[02:10.35] Rivers get connected so much stronger than expected well\n[02:16.51] Sick love comes to wash us away\n[02:23.07] Prisons of perspective\n[02:25.63] How your vision gets corrected and\n[02:29.59] Sick love is my modern cliche\n[02:35.53] \n[03:01.73] Rivers get connected so much stronger than expected well\n[03:08.12] Sick love comes to wash us away\n[03:14.47] Prisons of perspective\n[03:17.19] How your vision gets corrected and\n[03:21.10] Sick love is my modern cliche\n[03:27.41] Openly defective is the lover you elected and\n[03:34.12] A portrait she was bound to portray\n[03:37.93] ","lyricsfile":null}
```

> Replace this line with notes (if needed) or remove it (if not needed).

## Part 2: New

> What is something new and/or exciting that you learned from working
> on this project?

It was really cool to put what we've learned in class to a concrete application I can actually use.
I learned a lot of new JavaFX features, as the basic ones we learned in class were not enough to complete everything.
I also learned how much code goes into seemingly simple applications. I chose a relatively  basic task, but the amount
of coding required to connect to the APIs and then actually style the app ended up being a lot more than I expected.
## Part 3: Retrospect

> If you could start the project over from scratch, what do
> you think might do differently and why?

I would plan everything out better and think about how the pieces interact before I started. I feel like I did a lot of copying and
pasting code to different places, because I realized it was either necessary/made more sense to organize the code in that way. I didn't fully
consider which methods should go where and what other methods they would call/depend on. I added a lot more methods as I went, and I should
have preplanned these ahead of time so that I had an easier time connecting everything.
