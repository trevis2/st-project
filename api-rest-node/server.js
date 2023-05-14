const fastify = require('fastify')({
    logger: true
})

const users = require('./data.json')

fastify.get('/', (req, resp) => {
    resp.send({
        hello: 'world'
    })
})

fastify.get('/users', (req, res) => {
    const q = req.query;
    const limit = parseInt(q.limit) || 10;
    const offset = parseInt(q.offset) || 0;
    const data = users.slice(offset, limit + offset);
    res.send({
        users: data
    })
})

fastify.get('/users/:id', (req, res) => {
    const id = req.params.id;
    const user = users.find((user) => { return user.id === parseInt(id) })
    if (!user) {
        res.send({
            error: 404
        })
    }
    res.send({
        user
    })
})

fastify.listen({ port: 3000 }, (err, address) => {
    if (err) {
        console.error(err)
    }
    console.log('running at add: ' + address)
})
