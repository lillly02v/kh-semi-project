( function ( $ ) {
	"use strict";
	
	//User chart
	var ctx = document.getElementById( "user-chart" );
	ctx.height = 150;
	var myChart = new Chart( ctx, {
		type: 'line',
		data: {
			labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
			type: 'line',
			defaultFontFamily: 'Montserrat',
			datasets: [ {
				data: [ monthVt[0] + monthWr[0], monthVt[1] + monthWr[1], monthVt[2] + monthWr[2], monthVt[3] + monthWr[3],
						monthVt[4] + monthWr[4], monthVt[5] + monthWr[5], monthVt[6] + monthWr[6], monthVt[7] + monthWr[7],
						monthVt[8] + monthWr[8], monthVt[9] + monthWr[9], monthVt[10] + monthWr[10], monthVt[11] + monthWr[11]],
				label: "Expense",
				backgroundColor: 'rgba(0,103,255,.15)',
				borderColor: 'rgba(0,103,255,0.5)',
				borderWidth: 3.5,
				pointStyle: 'circle',
				pointRadius: 5,
				pointBorderColor: 'transparent',
				pointBackgroundColor: 'rgba(0,103,255,0.5)',
                    }, ]
		},
		options: {
			responsive: true,
			tooltips: {
				mode: 'index',
				titleFontSize: 12,
				titleFontColor: '#000',
				bodyFontColor: '#000',
				backgroundColor: '#fff',
				titleFontFamily: 'Montserrat',
				bodyFontFamily: 'Montserrat',
				cornerRadius: 3,
				intersect: false,
			},
			legend: {
				display: false,
				position: 'top',
				labels: {
					usePointStyle: true,
					fontFamily: 'Montserrat',
				},


			},
			scales: {
				xAxes: [ {
					display: true,
					gridLines: {
						display: false,
						drawBorder: false
					},
					scaleLabel: {
						display: false,
						labelString: 'Month'
					}
                        } ],
				yAxes: [ {
					display: true,
					gridLines: {
						display: false,
						drawBorder: false
					},
					scaleLabel: {
						display: true,
						labelString: '방문자수'
					}
                        } ]
			},
			title: {
				display: false,
			}
		}
	} );

	//Team chart
	var ctx = document.getElementById( "team-chart" );
	ctx.height = 150;
	var myChart = new Chart( ctx, {
		type: 'line',
		data: {
			labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
			type: 'line',
			defaultFontFamily: 'Montserrat',
			datasets: [ {
				data: [ monthVt[0] + monthWr[0], monthVt[1] + monthWr[1], monthVt[2] + monthWr[2], monthVt[3] + monthWr[3],
						monthVt[4] + monthWr[4], monthVt[5] + monthWr[5], monthVt[6] + monthWr[6], monthVt[7] + monthWr[7],
						monthVt[8] + monthWr[8], monthVt[9] + monthWr[9], monthVt[10] + monthWr[10], monthVt[11] + monthWr[11]],
						label: "봉사자",
						data: [monthVt[0], monthVt[1], monthVt[2], monthVt[3], monthVt[4], monthVt[5], monthVt[6], monthVt[7], monthVt[8], monthVt[9], monthVt[10], monthVt[11]],
						backgroundColor: 'transparent',
						borderColor: 'rgba(220,53,69,0.75)',
						borderWidth: 3,
						pointStyle: 'circle',
						pointRadius: 5,
						pointBorderColor: 'transparent',
						pointBackgroundColor: 'rgba(220,53,69,0.75)',
		                    }, {
						label: "복지자",
						data: [monthWr[0], monthWr[1], monthWr[2], monthWr[3], monthWr[4], monthWr[5], monthWr[6], monthWr[7], monthWr[8], monthWr[9], monthWr[10], monthWr[11]],
						backgroundColor: 'transparent',
						borderColor: 'rgba(40,167,69,0.75)',
						borderWidth: 3,
						pointStyle: 'circle',
						pointRadius: 5,
						pointBorderColor: 'transparent',
						pointBackgroundColor: 'rgba(40,167,69,0.75)',
                    }, ]
		},
		options: {
			responsive: true,
			tooltips: {
				mode: 'index',
				titleFontSize: 12,
				titleFontColor: '#000',
				bodyFontColor: '#000',
				backgroundColor: '#fff',
				titleFontFamily: 'Montserrat',
				bodyFontFamily: 'Montserrat',
				cornerRadius: 3,
				intersect: false,
			},
			legend: {
				display: false,
				position: 'top',
				labels: {
					usePointStyle: true,
					fontFamily: 'Montserrat',
				},


			},
			scales: {
				xAxes: [ {
					display: true,
					gridLines: {
						display: false,
						drawBorder: false
					},
					scaleLabel: {
						display: false,
						labelString: 'Month'
					}
                        } ],
				yAxes: [ {
					display: true,
					gridLines: {
						display: false,
						drawBorder: false
					},
					scaleLabel: {
						display: true,
						labelString: '방문자수'
					}
                        } ]
			},
			title: {
				display: false,
			}
		}
	} );
	
	//Sales chart
	var ctx = document.getElementById( "sales-chart" );
	ctx.height = 150;
	var myChart = new Chart( ctx, {
		type: 'line',
		data: {
			labels: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
			type: 'line',
			defaultFontFamily: 'Montserrat',
			datasets: [ {
				label: "봉사자",
				data: [monthVt[0], monthVt[1], monthVt[2], monthVt[3], monthVt[4], monthVt[5], monthVt[6], monthVt[7], monthVt[8], monthVt[9], monthVt[10], monthVt[11]],
				backgroundColor: 'transparent',
				borderColor: 'rgba(220,53,69,0.75)',
				borderWidth: 3,
				pointStyle: 'circle',
				pointRadius: 5,
				pointBorderColor: 'transparent',
				pointBackgroundColor: 'rgba(220,53,69,0.75)',
                    }, {
				label: "복지자",
				data: [monthWr[0], monthWr[1], monthWr[2], monthWr[3], monthWr[4], monthWr[5], monthWr[6], monthWr[7], monthWr[8], monthWr[9], monthWr[10], monthWr[11]],
				backgroundColor: 'transparent',
				borderColor: 'rgba(40,167,69,0.75)',
				borderWidth: 3,
				pointStyle: 'circle',
				pointRadius: 5,
				pointBorderColor: 'transparent',
				pointBackgroundColor: 'rgba(40,167,69,0.75)',
                    } ]
		},
		options: {
			responsive: true,

			tooltips: {
				mode: 'index',
				titleFontSize: 12,
				titleFontColor: '#000',
				bodyFontColor: '#000',
				backgroundColor: '#fff',
				titleFontFamily: 'Montserrat',
				bodyFontFamily: 'Montserrat',
				cornerRadius: 3,
				intersect: false,
			},
			legend: {
				display: false,
				labels: {
					usePointStyle: true,
					fontFamily: 'Montserrat',
				},
			},
			scales: {
				xAxes: [ {
					display: true,
					gridLines: {
						display: false,
						drawBorder: false
					},
					scaleLabel: {
						display: false,
						labelString: 'Month'
					}
                        } ],
				yAxes: [ {
					display: true,
					gridLines: {
						display: false,
						drawBorder: false
					},
					scaleLabel: {
						display: true,
						labelString: '방문자수'
					}
                        } ]
			},
			title: {
				display: false,
				text: 'Normal Legend'
			}
		}
	} );
	
	//pie chart
	var totalCtx = document.getElementById( "totalPieChart" );
	ctx.height = 300;
	var totalChart = new Chart( totalCtx, {
		type: 'pie',
		data: {
			datasets: [ {
				data: [ ageTotal[0], ageTotal[1], ageTotal[2], ageTotal[3], ageTotal[4] ],
				backgroundColor: [
                                    "rgba(0, 123, 255,0.9)",
                                    "rgba(0, 123, 255,0.7)",
                                    "rgba(0, 123, 255,0.5)",
                                    "rgba(0, 123, 255,0.3)",
                                    "rgba(0,0,0,0.07)"
                                ],
				hoverBackgroundColor: [
									"rgba(0, 123, 255,0.9)",
                                    "rgba(0, 123, 255,0.7)",
                                    "rgba(0, 123, 255,0.5)",
                                    "rgba(0, 123, 255,0.3)",
                                    "rgba(0,0,0,0.07)"
                                ]

                            } ],
			labels: [
                            "10대",
                            "20대",
                            "30대",
                            "40대",
                            "50대"
                        ]
		},
		options: {
			responsive: true
		}
	} );

	//pie chart
	var vtCtx = document.getElementById( "vtPieChart" );
	ctx.height = 300;
	var vtChart = new Chart( vtCtx, {
		type: 'pie',
		data: {
			datasets: [ {
				data: [ ageVt[0], ageVt[1], ageVt[2], ageVt[3], ageVt[4] ],
				backgroundColor: [
                                    "rgba(110,0,11,0.75)",
                                    "rgba(220,53,69,0.75)",
                                    "rgba(247,104,118,0.75)",
                                    "rgba(251,167,175,0.75)",
                                    "rgba(0,0,0,0.07)"
                                ],
				hoverBackgroundColor: [
				                    "rgba(110,0,11,0.75)",
				                    "rgba(220,53,69,0.75)",
				                    "rgba(247,104,118,0.75)",
				                    "rgba(251,167,175,0.75)",
				                    "rgba(0,0,0,0.07)"
                                ]

                            } ],
			labels: [
                            "10대",
                            "20대",
                            "30대",
                            "40대",
                            "50대"
                        ]
		},
		options: {
			responsive: true
		}
	} );
	
	//pie chart
	var wrCtx = document.getElementById( "wrPieChart" );
	ctx.height = 300;
	var wrChart = new Chart( wrCtx, {
		type: 'pie',
		data: {
			datasets: [ {
				data: [ ageWr[0], ageWr[1], ageWr[2], ageWr[3], ageWr[4] ],
				backgroundColor: [
                                    "rgba(0,80,18,0.75)",
                                    "rgba(40,167,69,0.75)",
                                    "rgba(81,193,106,0.75)",
                                    "rgba(149,226,166,0.75)",
                                    "rgba(0,0,0,0.07)"
                                ],
				hoverBackgroundColor: [
				                    "rgba(0,80,18,0.75)",
				                    "rgba(40,167,69,0.75)",
				                    "rgba(81,193,106,0.75)",
				                    "rgba(149,226,166,0.75)",
				                    "rgba(0,0,0,0.07)"
                                ]

                            } ],
			labels: [
                            "10대",
                            "20대",
                            "30대",
                            "40대",
                            "50대"
                        ]
		},
		options: {
			responsive: true
		}
	} );
	

	
	
	
	//bar chart
	var ctx = document.getElementById( "barChart" );
	//    ctx.height = 200;
	var myChart = new Chart( ctx, {
		type: 'bar',
		data: {
			labels: [ "January", "February", "March", "April", "May", "June", "July" ],
			datasets: [
				{
					label: "My First dataset",
					data: [ 65, 59, 80, 81, 56, 55, 40 ],
					borderColor: "rgba(0, 123, 255, 0.9)",
					borderWidth: "0",
					backgroundColor: "rgba(0, 123, 255, 0.5)"
                            },
				{
					label: "My Second dataset",
					data: [ 28, 48, 40, 19, 86, 27, 90 ],
					borderColor: "rgba(0,0,0,0.09)",
					borderWidth: "0",
					backgroundColor: "rgba(0,0,0,0.07)"
                            }
                        ]
		},
		options: {
			scales: {
				yAxes: [ {
					ticks: {
						beginAtZero: true
					}
                                } ]
			}
		}
	} );
	


} )( jQuery );
