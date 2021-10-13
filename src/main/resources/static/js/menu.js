let pathname = window.location.pathname;

if (pathname.includes("home") || pathname.length === 0) {
    document.getElementById('1st-link').className = 'link active';
} else if (pathname.includes("organization")) {
    document.getElementById('2nd-link').className = 'link active';
    document.getElementById('1st-link').className = 'link';
} else if (pathname.includes("customer")) {
    document.getElementById('3rd-link').className = 'link active';
    document.getElementById('1st-link').className = 'link';
}