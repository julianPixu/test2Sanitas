package com.mycorp.services;

import com.mycorp.models.CorreoElectronico;

public interface MensajeriaService {

    void enviar( CorreoElectronico correo );

}
