const http = require('http');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
   res.statusCode = 200;
   res.setHeader('Content-Type', 'text/plain');
   res.se
   res.end(fibonacci().join("\n") + '\n');
});

server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
})

function fibonacci() {
    const maxValues = 20;
    var sequence  = [];
    let val1 = 0;
    let val2 = 1;

    for (let i = 0; i <= maxValues; i++) {
        if (i === 0 || i === 1) {
            sequence.push("F(" + i + ") = " + i);
        }
        else
        {
            let sum = val1 + val2;

            val1 = val2;
            val2 = sum;

            sequence.push("F(" + i + ") = " + sum);
        }
    }

    return sequence;
}