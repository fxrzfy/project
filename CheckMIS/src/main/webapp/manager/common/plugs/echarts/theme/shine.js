var shine = {
    // 默认色板
    color: [
        '#01BBBD','#9F78EE','#FFA944','#F16767',
        '#005eaa','#339ca8','#cda819','#32a487'
    ],

    // 图表标题
    title: {
        textStyle: {
            fontWeight: 'normal'
        }
    },
    
    // 值域
    dataRange: {
        itemWidth: 15,             // 值域图形宽度，线性渐变水平布局宽度为该值 * 10
        color:['#1790cf','#a2d4e6']
    },

    // 工具箱
    toolbox: {
        color : ['#06467c','#00613c','#872d2f','#c47630']
    },

    // 提示框
    tooltip: {
        backgroundColor: 'rgba(0,0,0,0.6)'
    },

    // 区域缩放控制器
    dataZoom: {
        dataBackgroundColor: '#dedede',            // 数据背景颜色
        fillerColor: 'rgba(154,217,247,0.2)',   // 填充颜色
        handleColor: '#005eaa'     // 手柄颜色
    },
    
    // 网格
    grid: {
        borderWidth: 0
    },

    // 类目轴
    categoryAxis: {
        axisLine: {            // 坐标轴线
            show: true,
            lineStyle: {
                color: "#53A7E0"
            }
        },
        axisTick: {            // 坐标轴小标记
            show: false
        },
        splitLine: {
            show: false
        }
    },

    // 数值型坐标轴默认参数
    valueAxis: {
        axisLine: {            // 坐标轴线
            show: true,
            lineStyle: {
                color: "#53A7E0"
            }
        },
        axisTick: {            // 坐标轴小标记
            show: false
        },
        splitArea: {           // 分隔区域
            show: false,       // 默认不显示，属性show控制显示与否
            areaStyle: {       // 属性areaStyle（详见areaStyle）控制区域样式
                color: ['rgba(250,250,250,0.2)','rgba(200,200,200,0.2)']
            }
        },
        splitLine: {
            show: false
            // lineStyle:{
            //     color:['#aaa'],
            //     type:'dashed'
            // }
        }
    },
    
    timeline : {
        lineStyle : {
            color : '#005eaa'
        },
        controlStyle : {
            normal : { color : '#005eaa'},
            emphasis : { color : '#005eaa'}
        }
    },

    // K线图默认参数
    k: {
        itemStyle: {
            normal: {
                color: '#ff7150',          // 阳线填充颜色
                color0: '#F16767',      // 阴线填充颜色
                lineStyle: {
                    width: 1,
                    color: '#ff7150',   // 阳线边框颜色
                    color0: '#F16767'   // 阴线边框颜色
                }
            }
        }
    },
    
    map: {
        itemStyle: {
            normal: {
                areaStyle: {
                    color: '#ddd'
                },
                label: {
                    textStyle: {
                        color: '#ff7150'
                    }
                }
            },
            emphasis: {                 // 也是选中样式
                areaStyle: {
                    color: '#FFA944'
                },
                label: {
                    textStyle: {
                        color: '#ff7150'
                    }
                }
            }
        }
    },
    
    force : {
        itemStyle: {
            normal: {
                linkStyle : {
                    color : '#005eaa'
                }
            }
        }
    },
    
    chord : {
        itemStyle : {
            normal : {
                borderWidth: 1,
                borderColor: 'rgba(128, 128, 128, 0.5)',
                chordStyle : {
                    lineStyle : {
                        color : 'rgba(128, 128, 128, 0.5)'
                    }
                }
            },
            emphasis : {
                borderWidth: 1,
                borderColor: 'rgba(128, 128, 128, 0.5)',
                chordStyle : {
                    lineStyle : {
                        color : 'rgba(128, 128, 128, 0.5)'
                    }
                }
            }
        }
    },
    
    gauge : {
        axisLine: {            // 坐标轴线
            show: false,        // 默认显示，属性show控制显示与否
            lineStyle: {       // 属性lineStyle控制线条样式
                color: [[0.2, '#F16767'],[0.8, '#005eaa'],[1, '#ff7150']], 
                width: 5
            }
        },
        axisTick: {            // 坐标轴小标记
            splitNumber: 10,   // 每份split细分多少段
            length :8,        // 属性length控制线长
            lineStyle: {       // 属性lineStyle控制线条样式
                color: 'auto'
            }
        },
        axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
            textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                color: 'auto'
            }
        },
        splitLine: {           // 分隔线
            length : 12,         // 属性length控制线长
            lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                color: 'auto'
            }
        },
        pointer : {
            length : '90%',
            width : 3,
            color : 'auto'
        },
        title : {
            textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                color: '#333'
            }
        },
        detail : {
            textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                color: 'auto'
            }
        }
    },
    
    textStyle: {
        fontFamily: '微软雅黑, Arial, Verdana, sans-serif'
    }
};