package com.leoneves.maktaba.radiocheckswitch;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leoneves.maktaba.R;

/**
 * Created by leo on 22/02/16.
 */
public class Switch extends LinearLayout{
    private Context context;
    private TypedArray typedArray;
    private View view;
    private RippleView rippleView;
    private LinearLayout linearLayoutSwitch;
    private LinearLayout linearLayoutRadio;
    private TextView titulo;
    private TextView resposta;
    private RadioButton buttonSim;
    private RadioButton buttonNao;
    private SwitchAlone aSwitch;
    private OnCheckedChangeListener onCheckedChangeListener;
    private int modo = MODO_TOGGLE;
    private int orientation = LinearLayout.VERTICAL;

    public static final int MODO_RADIO = 0;
    public static final int MODO_TOGGLE = 1;

    public Switch(Context context){
        super(context);
        this.context = context;
        init();
        configureListeners();
    }

    public Switch(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
        initAttrs(attrs);
        configureListeners();
        configureTitulo();
        configurarModo();
    }

    private void init(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.switch_layout, this);
        titulo = (TextView)view.findViewById(R.id.textViewRadioGroupMaterial);
        buttonSim = (RadioButton)view.findViewById(R.id.radioButtonSim);
        buttonNao = (RadioButton)view.findViewById(R.id.radioButtonNao);
        rippleView = (RippleView)view.findViewById(R.id.rippleComponentSwitch);
        linearLayoutSwitch = (LinearLayout)view.findViewById(R.id.linearLayoutSwitchMaterial);
        linearLayoutRadio = (LinearLayout)view.findViewById(R.id.linearLayoutRadioMaterial);
        aSwitch = (SwitchAlone) view.findViewById(R.id.switchMaterial);
        resposta = (TextView)view.findViewById(R.id.switchMaterialResposta);
    }

    private void initAttrs(AttributeSet attrs){
        typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Switch, 0, 0);
        modo = typedArray.getInt(R.styleable.Switch_sw_tipo, MODO_TOGGLE);
        orientation = typedArray.getInteger(R.styleable.Switch_android_orientation, LinearLayout.VERTICAL);
        boolean checked = typedArray.getBoolean(R.styleable.Switch_android_checked, false);
        setChecked(checked);
    }

    private void configureTitulo(){
        titulo.setText(typedArray.getString(R.styleable.Switch_sw_titulo));
    }

    private void configurarModo(){
        if (modo==MODO_RADIO){
            linearLayoutRadio.setVisibility(VISIBLE);
            linearLayoutSwitch.setVisibility(GONE);
            linearLayoutRadio.setOrientation(orientation);
        }
        if (modo == MODO_TOGGLE){
            linearLayoutRadio.setVisibility(GONE);
            linearLayoutSwitch.setVisibility(VISIBLE);
        }
    }

    private void configureListeners(){
        buttonSim.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSim.setChecked(true);
                buttonNao.setChecked(false);
                salvar();
            }
        });
        buttonNao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonNao.setChecked(true);
                buttonSim.setChecked(false);
                salvar();
            }
        });
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                if (aSwitch.getVisibility() == VISIBLE)
                    aSwitch.setChecked(!aSwitch.isChecked());
            }
        });
        aSwitch.setOnCheckedChangeListener(new SwitchAlone.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchAlone view, boolean checked) {
                resposta.setText(checked ? context.getString(R.string.sim) : context.getString(R.string.nao));
                salvar();
                if (onCheckedChangeListener != null && aSwitch.getVisibility() == VISIBLE)
                    onCheckedChangeListener.checkStatus(Switch.this, checked);
            }
        });
        linearLayoutSwitch.setClickable(false);
        linearLayoutSwitch.setEnabled(false);
        linearLayoutRadio.setOnTouchListener(null);
        linearLayoutRadio.setClickable(false);
        linearLayoutRadio.setEnabled(false);
    }

    private void salvar(){
    }

    public Boolean isChecked(){
        if (modo==MODO_RADIO)
            return buttonSim.isChecked()==buttonNao.isChecked() ? null : buttonSim.isChecked();
        else
            return aSwitch.isChecked();
    }

    public void setModo(int modo){
        if (modo!=MODO_RADIO && modo!=MODO_TOGGLE) throw new IllegalArgumentException();
        this.modo = modo;
        configurarModo();
    }

    public void setOrientation(int orientation){
        this.orientation = orientation;
        if (linearLayoutRadio!=null)
            linearLayoutRadio.setOrientation(orientation);
    }

    public int getValor(){
        if (isChecked())
            return -1;
        return -2;
    }

    public void setChecked(boolean checked){
        buttonSim.setChecked(checked);
        buttonNao.setChecked(!checked);
        aSwitch.setChecked(checked);
        resposta.setText(checked ? context.getString(R.string.sim) : context.getString(R.string.nao));
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener){
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public interface OnCheckedChangeListener {
        void checkStatus(Switch view, boolean selected);
    }

    public void setColor(int color){
        aSwitch.setColor(color);
    }

    public void setText(String text){
        titulo.setText(text);
    }

    public void setEnabled(boolean enabled){
        buttonSim.setEnabled(enabled);
        buttonNao.setEnabled(enabled);
        aSwitch.setVisibility(enabled ? VISIBLE : GONE);
        resposta.setVisibility(enabled ? GONE : VISIBLE);
    }

}
