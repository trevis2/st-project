import { useState } from "react"

export function Counter() {
    const [count, setCount] = useState(10);
    return (
        <div>
            Count: {count}
            <div>
                <button onClick={() => setCount(count - 1)}>
                    Decrement
                </button>
                <button onClick={() => setCount(count + 1)}>
                    Increment
                </button>
            </div>

        </div>)
}