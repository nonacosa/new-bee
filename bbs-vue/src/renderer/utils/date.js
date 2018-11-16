var format = require('date-fns/format')

export function coverDate(date) {
    return format(
        date,
        'YYYY-MM-DD'
    )
}