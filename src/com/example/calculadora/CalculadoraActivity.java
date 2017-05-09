package com.example.calculadora;

import android.R.array;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends Activity {

	//Componentes
    private TextView textViewPrimario;
    private TextView textViewSecundario;
    private TextView textViewM;
    private Button ButtonC;
    private Button ButtonMC;
    private Button ButtonMR;
    private Button ButtonMPlus;
    private Button ButtonBackSpace;
    private Button ButtonPlusMinus;
    private Button ButtonPorcentagem;
    private Button ButtonDivisao;
    private Button ButtonVezes;
    private Button ButtonMenos;
    private Button ButtonMais;
    private Button Button9;
    private Button Button8;
    private Button Button7;
    private Button Button6;
    private Button Button5;
    private Button Button4;
    private Button Button3;
    private Button Button2;
    private Button Button1;
    private Button Button0;
    private Button ButtonVirgula;
    private Button ButtonIgual;

    //Vars
    private String valor1 = "";
    private String valor2 = "";
    private char simbolo;
    private boolean segundoValor = false;
    private double resultado = 0;
    private boolean negativo1 = false;
    private boolean negativo2 = false;
    private double saved = 0;

    //Cor dos botões dos números
    //Pressionado (Vale para todos, exceto para o igual)
    private int corP = 0xFF158bb2;
    //Normal
    private int corN = 0xFF333232;
    //Cor dos botões de símbolos
    private int corS = 0xFF433c3c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //Pegando o componente pelo id
        textViewPrimario = (TextView) findViewById(R.id.textViewPrincipal);
        textViewSecundario = (TextView) findViewById(R.id.textViewSecundario);
        textViewM = (TextView) findViewById(R.id.textViewM);
        Button0 = (Button) findViewById(R.id.Button0);
        Button1 = (Button) findViewById(R.id.Button1);
        Button2 = (Button) findViewById(R.id.Button2);
        Button3 = (Button) findViewById(R.id.Button3);
        Button4 = (Button) findViewById(R.id.Button4);
        Button5 = (Button) findViewById(R.id.Button5);
        Button6 = (Button) findViewById(R.id.Button6);
        Button7 = (Button) findViewById(R.id.Button7);
        Button8 = (Button) findViewById(R.id.Button8);
        Button9 = (Button) findViewById(R.id.Button9);
        ButtonC = (Button) findViewById(R.id.ButtonC);
        ButtonMC = (Button) findViewById(R.id.ButtonMC);
        ButtonMR = (Button) findViewById(R.id.ButtonMR);
        ButtonMPlus = (Button) findViewById(R.id.ButtonMPlus);
        ButtonBackSpace = (Button) findViewById(R.id.ButtonBackSpace);
        ButtonPlusMinus = (Button) findViewById(R.id.ButtonPlusMinus);
        ButtonPorcentagem = (Button) findViewById(R.id.ButtonPorcentagem);
        ButtonDivisao = (Button) findViewById(R.id.ButtonDivisao);
        ButtonVezes = (Button) findViewById(R.id.ButtonVezes);
        ButtonMenos = (Button) findViewById(R.id.ButtonMenos);
        ButtonMais = (Button) findViewById(R.id.ButtonMais);
        ButtonVirgula = (Button) findViewById(R.id.ButtonVirgula);
        ButtonIgual = (Button) findViewById(R.id.ButtonIgual);
        
      //Botões dos Símbolos
        ButtonDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simbolo = '÷';
                if (negativo1) {
                    textViewSecundario.setText("-" + valor1 + " " + simbolo);
                } else {
                    textViewSecundario.setText(valor1 + " " + simbolo);
                }
                segundoValor = true;
                textViewPrimario.setText("0");
            }
        });

        ButtonVezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simbolo = 'X';
                if (negativo1) {
                    textViewSecundario.setText("-" + valor1 + " " + simbolo);
                } else {
                    textViewSecundario.setText(valor1 + " " + simbolo);
                }
                segundoValor = true;
                textViewPrimario.setText("0");
            }
        });

        ButtonMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simbolo = '+';
                if (negativo1) {
                    textViewSecundario.setText("-" + valor1 + " " + simbolo);
                } else {
                    textViewSecundario.setText(valor1 + " " + simbolo);
                }
                segundoValor = true;
                textViewPrimario.setText("0");
            }
        });

        ButtonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simbolo = '-';
                if (negativo1) {
                    textViewSecundario.setText("-" + valor1 + " " + simbolo);
                } else {
                    textViewSecundario.setText(valor1 + " " + simbolo);
                }
                segundoValor = true;
                textViewPrimario.setText("0");
            }
        });

        ButtonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.valueOf(valor1);
                System.out.printf("n1: " + n1);
                double n2 = Double.valueOf(valor2);
                System.out.printf("n2: " + n2);
                if (simbolo == '+') {
                    if (negativo1) {
                        if (negativo2) {
                            resultado = -n1 + (-n2);
                        } else {
                            resultado = (-n1) + n2;
                        }
                    } else {
                        if (negativo2) {
                            resultado = n1 + (-n2);
                        } else {
                            resultado = n1 + n2;
                        }
                    }
                } else if (simbolo == '-') {
                    if (negativo1) {
                        if (negativo2) {
                            resultado = (-n1) - (-n2);
                        } else {
                            resultado = (-n1) - n2;
                        }
                    } else {
                        if (negativo2) {
                            resultado = n1 - (-n2);
                        } else {
                            resultado = n1 - n2;
                        }
                    }
                } else if (simbolo == 'X') {
                    if (negativo1) {
                        if (negativo2) {
                            resultado = (-n1) * (-n2);
                        } else {
                            resultado = (-n1) * n2;
                        }
                    } else {
                        if (negativo2) {
                            resultado = n1 * (-n2);
                        } else {
                            resultado = n1 * n2;
                        }
                    }
                } else if (simbolo == '÷' && n1 != 0) {
                    if (negativo1) {
                        if (negativo2) {
                            resultado = (-n1) / (-n2);
                        } else {
                            resultado = (-n1) / n2;
                        }
                    } else {
                        if (negativo2) {
                            resultado = n1 / (-n2);
                        } else {
                            resultado = n1 / n2;
                        }
                    }
                } else {
                    textViewPrimario.setText("Tente outros valores");
                }

                negativo1 = false;
                negativo2 = false;
                segundoValor = false;
                textViewSecundario.setText("");
                textViewPrimario.setText(String.valueOf(resultado));
                valor1 = "";
                valor2 = "";
            }
        });

        ButtonPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (segundoValor) {
                    if (!negativo2) {
                        negativo2 = true;
                        textViewPrimario.setText("-" + valor2);
                    } else {
                        negativo2 = false;
                        textViewPrimario.setText(valor2);
                    }
                } else {
                    if (!negativo1) {
                        negativo1 = true;
                        textViewPrimario.setText("-" + valor1);
                    } else {
                        negativo1 = false;
                        textViewPrimario.setText(valor1);
                    }
                }
            }
        });

        //Outros botões
        ButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1 = "";
                valor2 = "";
                textViewPrimario.setText("0");
                textViewSecundario.setText("");
            }
        });

        ButtonMPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saved = resultado;
                textViewM.setText("M");
            }
        });

        ButtonMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (segundoValor) {
                    valor2 = String.valueOf(saved);
                } else {
                    valor1 = String.valueOf(saved);
                }
                textViewPrimario.setText(String.valueOf(saved));
            }
        });

        ButtonMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saved = 0;
                textViewM.setText("");
            }
        });
        
        ButtonBackSpace.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!segundoValor) {
					if (valor1.length() >= 2) {
						System.out.println("V:" +valor1);
						valor1 = valor1.substring(0, valor1.length()-1);
						textViewPrimario.setText(valor1);
					}
				}
				
			}
		});
        
        ButtonVirgula.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!segundoValor) {
					if (valor1.length() > 0) {
						valor1 = valor1.concat(".");
						textViewPrimario.setText(valor1);
					}
				}
				else{
					if (valor2.length() > 0) {
						valor2 = valor2.concat(".");
						textViewPrimario.setText(valor2);
					}
				}
			}
		});
        
        ButtonPorcentagem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!segundoValor) {
					if (valor1.length() > 0) {
						valor1 = "0";
						textViewPrimario.setText(valor1);
					}
				}
				else{
					if (valor2.length() > 0) {
						int v2 = Integer.valueOf(valor2);
						int v1 = Integer.valueOf(valor1);
						int r = (v2 * v1) / 100;
						valor2 = String.valueOf(r);
						textViewPrimario.setText(valor2);
					}
				}
			}
		});
    }

    //metodo acionado quando os btn numéricos são clicados
	public void addNumero(View v){
		Integer num;
		// recebe a Tag do btn clicado
		num = Integer.valueOf(v.getTag().toString());
		if (!segundoValor) {
            valor1 = valor1.concat(num.toString());
            textViewPrimario.setText(valor1);
        } else {
            valor2 = valor2.concat(num.toString());
            textViewPrimario.setText(valor2);
        }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculadora, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up Button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
