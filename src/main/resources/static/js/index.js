// Load the Visualization API and the corechart package
google.charts.load('current', {'packages': ['corechart']});

// Set a callback to run when the Google Visualization API is loaded
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

    // Create the data table
    let data = new google.visualization.DataTable();
    data.addColumn('string', 'Organization');
    data.addColumn('number', 'Member');
    data.addRows([
        ['Vietcombank', 15],
        ['Viettinbank', 5],
        ['Baovietbank', 8],
        ['Agribank', 19],
        ['Oceanbank', 3]
    ]);

    // Set the chart options
    const options = {
        'title': 'Number of customers by Organization',
        'width': '100%',
        'height': '600'
    };

    // Instantiate and draw the chart, passing in some options
    let chart = new google.visualization.PieChart(document.getElementById('chart'));
    chart.draw(data, options);
}