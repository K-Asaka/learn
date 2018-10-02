export const hello = (message: string): void => {
    log(message);
};

function log(message: string): void {
    document.body.innerText = `${message}`;
    console.log(message);
}

export function piyo() {
    
}
